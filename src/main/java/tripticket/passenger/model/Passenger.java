package tripticket.passenger.model;

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
@Table(name = "passenger_passengers")
public class Passenger implements Serializable {

	@Embedded
	private Address address;
	
	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name = "identification")
	private String identification;

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"firstname\": \"").append(getFirstname()).append("\",")
			.append("\"lastname\": \"").append(getLastname()).append("\",")
			.append("\"identification\": \"").append(getIdentification()).append("\",")
			.append("\"email\": \"").append(getAddress().getEmail()).append("\",")
			.append("\"phone_number\": \"").append(getAddress().getPhoneNo()).append("\",")
			.append("\"town\": \"").append(getAddress().getTown()).append("\",")
			.append("\"box\": \"").append(getAddress().getBox()).append("\"")
		.append("}");
		
		return sb.toString();
		
	}
	
	
}