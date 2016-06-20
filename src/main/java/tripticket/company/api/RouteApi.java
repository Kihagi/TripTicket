package tripticket.company.api;

/*
 * Sam Kiragu
 */

import javax.ws.rs.Path;

import tripticket.company.bean.RouteBeanI;
import tripticket.company.model.Route;

@Path("/route")
public class RouteApi {
	
	private RouteBeanI routeBean;
	
	@Path("/add")
	public String add(Route route){
		routeBean.add(route);
		
		return "{success : true}";
	}
	

}
