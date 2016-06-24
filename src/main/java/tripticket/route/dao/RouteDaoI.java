package tripticket.route.dao;

/*
 * @Sam Kiragu
 */

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.route.model.Route;

public interface RouteDaoI {
	
	Route add(Route route);
	
	Route load(Route route);
	
	List<Route> list(Route filter);
	
	void delete(Long fromLocationId, Long toLocationId);

	void setEmm(EntityManager emm);

}

