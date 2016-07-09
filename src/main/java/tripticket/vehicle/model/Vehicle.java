package tripticket.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veh_vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String regNo;
	
	@Column(name = "type")
	private String type;

	@Column(name = "size")
	private String size;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getReg_no() {
		return regNo;
	}

	public void setReg_no(String regNo) {
		this.regNo = regNo;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"type\": \"").append(getType()).append("\",")
			.append("\"regNo\": \"").append(getReg_no()).append("\",")
			.append("\"size\": \"").append(getSize()).append("\"")
		.append("}");
		
		return sb.toString();
		
	}

	
}
