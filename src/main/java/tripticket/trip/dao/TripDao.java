package tripticket.trip.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tripticket.trip.model.Trip;

public class TripDao implements TripDaoI{


	public List<Trip> list(Trip filter) {
		List<Trip>  trips = new ArrayList<Trip>();
		
		Trip trip = new Trip();
		trip.setTripId(1004);
		trip.setDepatureTime( new Date());
		trip.setArrivalTime( new Date());
		trip.setRoute("MBS NB");
		trip.setVehicle("BUS");
		trip.setPrice(1200.50);
		trips.add(trip);
		
		Trip trip1 = new Trip();
		trip1.setTripId(1005);
		trip1.setDepatureTime( new Date());
		trip1.setArrivalTime( new Date());
		trip1.setRoute("NB MBS");
		trip1.setVehicle("VAN");
		trip1.setPrice(1000.50);
		trips.add(trip1);
		
		return trips;
	}

	public void delete(Long tripId) {
		// TODO Auto-generated method stub
		
	}

	public Trip add(Trip trip) {
		// TODO Auto-generated method stub
		return null;
	}

	public Trip load(Trip trip) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
