package tripticket.company.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.company.dao.RouteDaoI;
import tripticket.company.model.Route;

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
