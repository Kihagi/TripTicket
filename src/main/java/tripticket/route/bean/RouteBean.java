package tripticket.route.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.route.dao.RouteDaoI;
import tripticket.route.model.Route;

@Stateless
public class RouteBean implements RouteBeanI{
	
	@Inject
	private RouteDaoI routeDao;

	public void add(Route route) {
		if(route == null || route.getFromLocationId() == null)
			return;
		routeDao.add(route);
		
	}

	public List<Route> list() {
		return routeDao.list(new Route());
	}

}

