package tripticket.route.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Sam Kiragu
 */
@Entity
@Table(name = "route_routes")
public class Route implements Serializable{
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "from_location")
	private Long  fromLocationId;
	
	@Column(name = "to_location")
	private Long toLocationId;
	
	@Column(name = "approx_distance")
	private Double distance;
	
	@Column(name = "approx_time")
	private Double ApproxTime;
	
	@Column(name = "comp_id")
	private Long companyId;
	
	public Long getFromLocationId() {
		return fromLocationId;
	}

	public void setFromLocationId(Long fromLocationId) {
		this.fromLocationId = fromLocationId;
	}

	public Long getToLocationId() {
		return toLocationId;
	}

	public void setToLocationId(Long toLocationId) {
		this.toLocationId = toLocationId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getApproxTime() {
		return ApproxTime;
	}

	public void setApproxTime(Double approxTime) {
		ApproxTime = approxTime;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"fromLocationId\": \"").append(getFromLocationId()).append("\",")
			.append("\"distance\": \"").append(getDistance()).append("\",")
			.append("\"companyId\": \"").append(getCompanyId()).append("\",")
			.append("\"Approximate Time\": \"").append(getApproxTime()).append("\",")
			.append("\"toLocation\": \"").append(getToLocationId()).append("\"")
		.append("}");
		
		return sb.toString();
		
	}
	
	
}

