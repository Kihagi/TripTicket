package tripticket.route.bean;

/*
 * @Sam Kiragu
 */

import java.util.List;

import tripticket.route.model.Route;;

public interface RouteBeanI {
	
	void add(Route route);
	
	List<Route> list();

}
