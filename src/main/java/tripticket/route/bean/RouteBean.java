package tripticket.route.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.route.dao.RouteDaoI;
import tripticket.route.model.Route;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RouteBean implements RouteBeanI{
	
	@PersistenceContext
	private EntityManager emm;
	
	@Inject
	private RouteDaoI routeDao;
	
	@PostConstruct
	public void init(){
		routeDao.setEmm(emm);
	}

	public void add(Route route) {
		if(route == null || route.getFromLocationId() == null)
			return;
		routeDao.add(route);
		
	}

	public List<Route> list() {
		return routeDao.list(new Route());
	}

}

