package tripticket.location.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trioticket.location.model.Location;

public interface LocationDaoI {
	
	Location add(Location location);
	
	Location remove(Location location);
	
	List<Location> list(Location filter);

	void setEm(EntityManager em);
	
	void delete(Long locationId);

}
