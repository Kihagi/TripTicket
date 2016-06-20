package tripticket.trip.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.trip.dao.TripDaoI;
import tripticket.trip.model.Trip;

@Stateless
public class TripBean implements TripBeanI{
	
	@Inject
	private TripDaoI tripDao;
	
	public void add(Trip trip){
		if(trip == null || trip.getVehicle() == null )
			
			return;
		
		tripDao.add(trip);
	}
	
	public List<Trip> list(){
		return tripDao.list( new Trip());
	}
	
	

}
