package tripticket.location.bean;

import java.util.List;

import trioticket.location.model.Location;

public interface LocationBeanI {
	
	void add(Location location);

	List<Location> list();
	
	boolean delete(int id);

	String listInJson();

	String load(int id);

}
