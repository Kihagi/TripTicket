package tripticket.route.dao;

/*
 * @Sam Kiragu
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import tripticket.route.model.Route;;

public class RouteDao implements RouteDaoI{
	
	private EntityManager emm;
	
	public void setEmm(EntityManager emm) {
		this.emm = emm;
		
	}

	public Route add(Route route) {
		return emm.merge(route);
	}

	public Route load(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Route> list(Route filter) {
		return emm.createQuery("from Route r").getResultList();
	}

	public void delete(Long fromLocationId, Long toLocationId) {
		// TODO Auto-generated method stub
		
	}

	
}

