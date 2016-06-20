package tripticket.passenger.dao;

import java.util.List;

import tripticket.passenger.model.Passenger;

public interface PassengerDaoI {

	Passenger load (Passenger passenger);
	
	Passenger add (Passenger passenger);
	
	List <Passenger> list (Passenger filter);
	
	void delete (Long passengerId);
}
