package tripticket.trip.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.trip.model.Trip;

public class TripDao implements TripDaoI{
	
	private EntityManager em;


	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Trip add(Trip trip) {
		return em.merge(trip);
	}
	
	public Trip load(Trip trip) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Trip> list(Trip filter) {
		return em.createQuery("from Trip t").getResultList();
	}

	public void delete(Long tripId) {
		// TODO Auto-generated method stub
		
	}

}
