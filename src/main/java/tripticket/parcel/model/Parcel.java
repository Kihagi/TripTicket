package tripticket.parcel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parcel_parcels")

public class Parcel {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long parcelId;
	
	@Column(name = "parcel_to")
	private String parcelTo;
	
	@Column(name = "parcel_from")
	private String parcelFrom;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String parcelDescription;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "cost",columnDefinition = "DOUBLE")
	private Double parcelcost;
	
	
	
	
	
	
	
	public Double getParcelcost() {
		return parcelcost;
	}

	public void setParcelcost(Double parcelcost) {
		this.parcelcost = parcelcost;
	}

	public Long getParcelId() {
		return parcelId;
	}

	public void setParcelId(Long parcelId) {
		this.parcelId = parcelId;
	}

	public String getParcelTo() {
		return parcelTo;
	}

	public void setParcelTo(String parcelTo) {
		this.parcelTo = parcelTo;
	}

	public String getParcelFrom() {
		return parcelFrom;
	}

	public void setParcelFrom(String parcelFrom) {
		this.parcelFrom = parcelFrom;
	}

	public String getParcelDescription() {
		return parcelDescription;
	}

	public void setParcelDescription(String parcelDescription) {
		this.parcelDescription = parcelDescription;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	
}
