package tripticket.location.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trioticket.location.model.Location;

public class LocationDao implements LocationDaoI {
	
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
		
	}

	public Location add(Location location) {
		return em.merge(location);
	}

	public Location remove(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Location> list(Location filter) {
		return em.createQuery("from Location l").getResultList();
	}

	public void delete(Long locationId) {
		// TODO Auto-generated method stub
		
	}

	

}
