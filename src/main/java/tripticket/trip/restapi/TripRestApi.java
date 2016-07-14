package tripticket.trip.restapi;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tripticket.trip.bean.TripBeanI;

public class TripRestApi {
	
	@EJB
	private TripBeanI tripBean;
	
	@GET
	@Path("list")
	@Produces (MediaType.APPLICATION_JSON)
	public Response list(){
		
		return Response.ok().entity(tripBean.list()).build();
	}
	

}