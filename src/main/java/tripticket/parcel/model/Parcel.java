package tripticket.parcel.model;

import trioticket.location.model.Location;
import tripticket.route.model.Route;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "parcel_parcels")

public class Parcel implements Serializable {
	
	public static final long SerialVersionUI=1L;
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
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
	

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "route_id")
    private Route routeId;
    
    
    @ManyToOne
	private Location from;
    
    @ManyToOne
	private Location to;
    

	@Transient
    private Long toId;
    
    @Transient
    private Long fromId;
    
    
	
	
	
	
	
	
	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Double getParcelcost() {
		return parcelcost;
	}

	public void setParcelcost(Double parcelcost) {
		this.parcelcost = parcelcost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	 public Location getFrom() {
			return from;
		}

	public void setFrom(Location from) {
			this.from = from;
		}

	public Location getTo() {
			return to;
		}

	public void setTo(Location to) {
			this.to = to;
		}

/*	public String getJson() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"parcelId\": \"").append(getParcelId()).append("\",")
			.append("\"parcelTo\": \"").append(getParcelTo()).append("\",")
			.append("\"parcelFrom\": \"").append(getParcelFrom()).append("\",")
			.append("\"parcelDescription\": \"").append(getParcelDescription()).append("\",")
			.append("\"route\": \"").append(getRoute()).append("\",")
			.append("\"parcelcost\": \"").append(getParcelcost()).append("\"")
		.append("}");
		
		return sb.toString();
	}*/
	public String getJson(){
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("\"id\": \"").append(getId()).append("\",")
			.append("\"parcelTo\": \"").append(getParcelTo()).append("\",")
			.append("\"parcelFrom\": \"").append(getParcelFrom()).append("\",")
			.append("\"parcelDescription\": \"").append(getParcelDescription()).append("\",")
			
			.append("\"from\": \"").append(getFrom() == null ? "N/A" : getFrom().getName()).append("\",")
			.append("\"fromId\": \"").append(getFrom() == null ? null : getFrom().getId()).append("\",")
			.append("\"to\": \"").append(getTo() == null ? "N/A" : getTo().getName()).append("\",")
			.append("\"toId\": \"").append(getTo() == null ? null : getTo().getId()).append("\",")
			.append("\"route\": \"").append(getRoute()).append("\",")
			.append("\"parcelcost\": \"").append(getParcelcost()).append("\"");
		sb.append("}");
		
		return sb.toString();
	

	
}
}
