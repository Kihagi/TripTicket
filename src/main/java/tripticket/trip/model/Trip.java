package tripticket.trip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "comp_trips")
public class Trip{
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "depatureTime")
	private String depatureTime;
	
	@Column(name = "arrivalTime")
	private String arrivalTime;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "price",columnDefinition = "DOUBLE")
	private double price;
	
	public Long getId() {
		return id;
	}

	public void setTripId(Long id) {
		this.id = id;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	public String getJson(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		.append("\"id\": \"").append(getId()).append("\",")
		.append("\"arrivalTime\": \"").append(getArrivalTime()).append("\",")
		.append("\"depatureTime\": \"").append(getDepatureTime()).append("\",")
		.append("\"price\": \"").append(getPrice()).append("\",")
		.append("\"route\": \"").append(getRoute()).append("\",")
	.append("}");
		
		return sb.toString();
		
		
		
	}

}
