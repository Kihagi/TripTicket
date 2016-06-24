package tripticket.trip.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tripticket.route.model.Route;


@Entity
@Table(name = "comp_trips")
public class Trip{
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int tripId;
	
	@Column(name = "depature_time")
	private String depatureTime;
	
	@Column(name = "arrival_time")
	private String arrivalTime;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "vehicle")
	private String vehicle;
	
	@Column(name = "price",columnDefinition = "DOUBLE")
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "route_id")
	private Route route_id;

	
	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
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

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

}
