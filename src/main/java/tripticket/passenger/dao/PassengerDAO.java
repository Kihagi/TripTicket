package tripticket.passenger.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import tripticket.passenger.model.Passenger;

public class PassengerDAO implements PassengerDaoI {
	private EntityManager emanager;

	public void setEntityManager(EntityManager emanager) {
		this.emanager = emanager;
	}

	public Passenger load(Passenger passenger) {
		// TODO Auto-generated method stub
		return null;
	}

	public Passenger add(Passenger passenger) {
		return emanager.merge(passenger);
	}

	public List<Passenger> list(Passenger filter) {
		return emanager.createQuery("from Passenger p").getResultList();
	}

	public void delete(Long passengerId) {
		

	}

}
