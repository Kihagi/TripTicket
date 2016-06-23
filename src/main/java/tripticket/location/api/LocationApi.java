package tripticket.location.api;

import javax.ws.rs.Path;

import trioticket.location.model.Location;
import tripticket.location.bean.LocationBeanI;

@Path("/location")
public class LocationApi {
	
	private LocationBeanI locationBean;
	
	
	@Path("/add")
	public String add(Location location){
		
		locationBean.add(location) ;
		
		return "{success: true}" ;
	}
	
}
