package tripticket.passenger.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.passenger.dao.PassengerDaoI;
import tripticket.passenger.model.Passenger;

@Stateless
public class PassengerBean implements PassengerBeanI {
	
	@Inject
	private PassengerDaoI passengerDao;
	
	public void add(Passenger passenger) {
		if (passenger == null || passenger.getFirstname() == null || passenger.getLastname() == null){
			return;
		}
		passengerDao.add(passenger);
	}

	public List<Passenger> list() {
		return passengerDao.list(new Passenger ());
		
	}

}
