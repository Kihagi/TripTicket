package tripticket.route.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.company.model.Company;
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
		routeDao.setEm(emm);
	}

	public void add(Route route) {
		if(route == null || route.getFromLocationId() == null)
			return;
		routeDao.save(route);
		
	}

	public List<Route> list() {
		return routeDao.list(new Route());
	}

	public boolean delete(Long id) {
		routeDao.delete(id);
		return true;
	}

	public String listInJson() {
		Map<String, Object> filter = new HashMap<String, Object>();
		
		
		List<Route> routes = routeDao.list(filter);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = routeDao.countAll();
		for(Route route : routes){
			sb.append(route.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
		
	}

	public String load(Long id) {
		Route route = routeDao.findById(id);
		
		if(route != null)
			return route.getJson();
		else
			return "{}";
	}

}

