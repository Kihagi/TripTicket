package tripticket.trip.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.trip.dao.TripDaoI;
import tripticket.trip.model.Trip;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TripBean implements TripBeanI{
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private TripDaoI tripDao;
	
	@PostConstruct
	public void init(){
		tripDao.setEm(em);
	}
	
	public void add(Trip trip){
		if(trip == null )
			return;
		
		tripDao.add(trip);
	}
	
	public List<Trip> list(){
		return tripDao.list( new Trip());
	}
	
	

}
