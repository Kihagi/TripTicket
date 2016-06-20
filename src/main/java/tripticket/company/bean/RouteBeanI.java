package tripticket.company.bean;

/*
 * @Sam Kiragu
 */

import java.util.List;

import tripticket.company.model.Route;;

public interface RouteBeanI {
	
	void add(Route route);
	
	List<Route> list();

}
