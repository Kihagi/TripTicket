package tripticket.location.dao;

import java.util.ArrayList;
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
		List<Object[]> results = em.createQuery("from Location l").getResultList();
		
		List<Location> locations = new ArrayList<Location>();
		Location location;
		
		for (Object [] result : results){
			location = new Location();
			location.setLocNo(result[0] == null ? null : (String) result[0]);
			location.setName(result[1] == null ? null : (String) result[1]);
			location.setDescr(result[1] == null ? null : (String) result[1]);
			
			locations.add(location);
						
		}
		
		return locations;
	}

	public void delete(Long locationId) {
		// TODO Auto-generated method stub
		
	}

	

}
