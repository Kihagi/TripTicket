package tripticket.route.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import trioticket.location.model.Location;

/*
 * @Sam Kiragu
 */
@Entity
@Table(name = "route_routes")
public class Route implements Serializable{
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Location from;
	
	@Transient
	private Long fromId;
	
	@ManyToOne
	private Location to;
	
	@Transient
	private Long toId;
	
	@Column(name = "approx_distance")
	private Double distance;
	
	@Column(name = "approx_time")
	private Double approxTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getFrom() {
		return from;
	}

	public void setFrom(Location from) {
		this.from = from;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Location getTo() {
		return to;
	}

	public void setTo(Location to) {
		this.to = to;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getApproxTime() {
		return approxTime;
	}

	public void setApproxTime(Double approxTime) {
		this.approxTime = approxTime;
	}
	
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"from\": \"").append(getFrom()).append("\",")
			.append("\"fromId\": \"").append(getFromId()).append("\",")
			.append("\"to\": \"").append(getTo()).append("\",")
			.append("\"toId\": \"").append(getToId()).append("\",")
			.append("\"approxTime\": \"").append(getApproxTime()).append("\"")
		.append("}");
		
		return sb.toString();
		
	}
	
	
}

