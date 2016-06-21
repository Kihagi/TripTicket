package tripticket.route.api;

/*
 * Sam Kiragu
 */

import javax.ws.rs.Path;

import tripticket.route.bean.RouteBeanI;
import tripticket.route.model.Route;

@Path("/route")
public class RouteApi {
	
	private RouteBeanI routeBean;
	
	@Path("/add")
	public String add(Route route){
		routeBean.add(route);
		
		return "{success : true}";
	}
	

}

