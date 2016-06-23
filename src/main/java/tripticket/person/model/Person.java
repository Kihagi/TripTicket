package tripticket.person.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tripticket.common.model.Address;
import tripticket.common.model.User;

@Entity
@Table(name = "psn_persons")
public class Person {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@Column(unique = true)
	private int personId;
	
	@Embedded
	private Address address;
	
	@Embedded
	private User user;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstname() {
		return fName;
	}

	public void setFirstname(String firstname) {
		this.fName = firstname;
	}

	public String getLastname() {
		return lName;
	}

	public void setLastname(String lastname) {
		this.lName = lastname;
	}

	public int getId() {
		return personId;
	}

	public void setId(int id) {
		this.personId = id;
	}

}
