package tripticket.company.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import tripticket.common.model.Address;

@NamedQueries({
	@NamedQuery(
			name = Company.NQ_ALL,
			query = "FROM Company c"
	),
	@NamedQuery(
			name = Company.NQ_FINDBYID,
			query = "FROM Company c WHERE c.id=:id"
	)
})
@Entity
@Table(name = "comp_companies")
@XmlRootElement
@JsonInclude(Include.NON_EMPTY)
public class Company implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Transient
	public static final String NQ_ALL = "Company.All";
	
	@Transient
	public static final String NQ_FINDBYID = "Company.findById";

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
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
		if(address ==  null)
			address = new Address();
		
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
	
	@JsonIgnore
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
