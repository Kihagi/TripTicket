package tripticket.location.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import trioticket.location.model.Location;
import tripticket.location.dao.LocationDaoI;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LocationBean implements LocationBeanI {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject 
	private LocationDaoI locationDao;
	
	@PostConstruct
	public void init(){
		locationDao.setEm(em);
	}
	

	public void add(Location location) {
		if(location == null || location.getName() == null)
			return;
		
		locationDao.add(location);
		
	}

	public List<Location> list() {
		return locationDao.list(new Location());
	}
	
	public boolean delete(Long id) {
		locationDao.delete(id);
		
		return true;
	}	

}
