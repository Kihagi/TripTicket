package tripticket.route.model;

/*
 * @Sam Kiragu
 */

public class Route {
	Long  fromLocationId;
	
	Long toLocationId;
	
	Double distance;
	
	Double ApproxTime;
	
	Long companyId;

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
	
}

