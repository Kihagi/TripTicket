package tripticket.trip.bean;

import java.util.List;

import tripticket.trip.model.Trip;

public interface TripBeanI {

	void add(Trip trip);
	
	String load(Long id);

	List<Trip> list();
	
	boolean delete(Long id);

	String listInJson();

}
