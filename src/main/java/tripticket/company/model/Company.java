package tripticket.company.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tripticket.common.model.Address;

@Entity
@Table(name = "comp_companies")
public class Company implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	@Column(name = "reg_no")
	private String regNo;
	
	@Column(name = "descr", columnDefinition = "TEXT")
	private String desc;
	
	@Embedded
	private Address address;
	
	public Company() {
	}
	
	public Company(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"name\": \"").append(getName()).append("\",")
			.append("\"regNo\": \"").append(getRegNo()).append("\",")
			.append("\"desc\": \"").append(getDesc()).append("\"");
		
		if(getAddress() != null){
			sb.append(",\"phoneNo\": \"").append(getAddress().getPhoneNo()).append("\",")
			.append("\"email\": \"").append(getAddress().getEmail()).append("\",")
			.append("\"town\": \"").append(getAddress().getTown()).append("\",")
			.append("\"country\": \"").append(getAddress().getCountry()).append("\",")
			.append("\"box\": \"").append(getAddress().getBox()).append("\"");
		}
			
		sb.append("}");
		
		return sb.toString();
		
	}
}
