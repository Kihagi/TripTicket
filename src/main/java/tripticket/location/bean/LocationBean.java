package tripticket.location.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import trioticket.location.model.Location;
import tripticket.location.dao.LocationDaoI;

@Stateless
public class LocationBean implements LocationBeanI {
	
	@Inject 
	private LocationDaoI locationDao;

	public void add(Location location) {
		if(location == null || location.getName() == null)
			return;
		
		locationDao.add(location);
		
	}

	public List<Location> list() {
		return locationDao.list(new Location());
	}
	
	

}
