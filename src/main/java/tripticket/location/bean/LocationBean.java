package tripticket.location.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		locationDao.save(location);
		
	}
	
	public String load(Long id){
		Location location = locationDao.findById(id);
		
		if(location != null)
			return location.getJson();
		else
			return "{}";
	}

	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();
		//filter.put("name", "sdadad");
		
		List<Location> locations = locationDao.list(filter);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = locationDao.countAll();
		for(Location location : locations){
			sb.append(location.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	public List<Location> list() {
		return locationDao.list(new Location());
	}
	
	
	public boolean delete(Long id) {
		locationDao.delete(id);
		
		return true;
	}	

}
