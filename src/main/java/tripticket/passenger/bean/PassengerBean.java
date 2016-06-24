package tripticket.passenger.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.passenger.dao.PassengerDaoI;
import tripticket.passenger.model.Passenger;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PassengerBean implements PassengerBeanI {
	@PersistenceContext
	private EntityManager emanager;
	
	@Inject
	private PassengerDaoI passengerDao;
	
	@PostConstruct
	public void init(){
		passengerDao.setEntityManager(emanager);
	}
	public void add(Passenger passenger) {
		if (passenger == null || passenger.getFirstname() == null || passenger.getLastname() == null)
			return;
		passengerDao.add(passenger);
	}

	public List<Passenger> list() {
		return passengerDao.list(new Passenger ());
		
	}

}
