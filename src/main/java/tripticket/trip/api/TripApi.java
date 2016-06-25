package tripticket.trip.api;
import javax.ws.rs.Path;

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;



@Path("/trips")
public class TripApi {
	
	private TripBeanI tripBean;
	
	@Path("/add")
	public String add(Trip trip){
		
		tripBean.add(trip);
		
		return "{success: true}";
	}

}
