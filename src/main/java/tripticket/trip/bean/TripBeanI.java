package tripticket.trip.bean;

import java.util.List;

import tripticket.trip.model.Trip;

public interface TripBeanI {

	void add(Trip trip);

	List<Trip> list();

}
