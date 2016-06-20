package tripticket.company.dao;

/*
 * @Sam Kiragu
 */

import java.util.ArrayList;
import java.util.List;

import tripticket.company.model.Route;

public class RouteDao implements RouteDaoI{

	public Route add(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	public Route load(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Route> list(Route filter) {
		List<Route> routes = new ArrayList<Route>();
		Route route = new Route();
		
		route.setFromLocationId(1L);
		route.setToLocationId(2L);
		route.setDistance(100.9);
		route.setApproxTime(4.3);
		route.setCompanyId(1L);
		routes.add(route);
		
		route = new Route();
		route.setFromLocationId(3L);
		route.setToLocationId(4L);
		route.setDistance(140.9);
		route.setApproxTime(3.3);
		route.setCompanyId(2L);
		routes.add(route);
		
		route = new Route();
		route.setFromLocationId(5L);
		route.setToLocationId(6L);
		route.setDistance(1090.9);
		route.setApproxTime(14.3);
		route.setCompanyId(3L);
		routes.add(route);
		
		route = new Route();
		route.setFromLocationId(7L);
		route.setToLocationId(8L);
		route.setDistance(1000.9);
		route.setApproxTime(54.3);
		route.setCompanyId(4L);
		routes.add(route);
		
		route = new Route();
		route.setFromLocationId(9L);
		route.setToLocationId(10L);
		route.setDistance(1060.9);
		route.setApproxTime(84.3);
		route.setCompanyId(5L);
		routes.add(route);
		
		route = new Route();
		route.setFromLocationId(1L);
		route.setToLocationId(2L);
		route.setDistance(100.9);
		route.setApproxTime(4.3);
		route.setCompanyId(1L);
		routes.add(route);
		
		return routes;
	}

	public void delete(Long fromLocationId, Long toLocationId) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
