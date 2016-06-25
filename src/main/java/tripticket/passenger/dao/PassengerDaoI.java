package tripticket.passenger.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.passenger.model.Passenger;

public interface PassengerDaoI {

	Passenger load(Passenger passenger);

	Passenger add(Passenger passenger);

	List<Passenger> list(Passenger filter);

	void delete(Long passengerId);

	void setEntityManager(EntityManager emanager);
}
