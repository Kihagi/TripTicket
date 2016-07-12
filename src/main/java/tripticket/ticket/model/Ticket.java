package tripticket.ticket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tic_bookings")
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String idNumber;
	
	@Column
	private String fullname;
	
	@Column
	private String phone;
	
	@Column
	private int tripId;
	
	@Column
	private String seat;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\", ")
			.append("\"idNumber\": \"").append(getIdNumber()).append("\", ")
			.append("\"fullname\": \"").append(getFullname()).append("\", ")
			.append("\"phone\": \"").append(getPhone()).append("\", ")
			.append("\"tripId\": \"").append(getTripId()).append("\", ")
			.append("\"seat\": \"").append(getSeat()).append("\"")
		.append("}");
		
		return sb.toString();
	}
	
	
}
