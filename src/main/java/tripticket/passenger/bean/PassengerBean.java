package tripticket.passenger.bean;

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

import tripticket.company.model.Company;
import tripticket.passenger.dao.PassengerDaoI;
import tripticket.passenger.model.Passenger;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PassengerBean implements PassengerBeanI {
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private PassengerDaoI passengerDao;
	
	@PostConstruct
	public void init(){
		passengerDao.setEm(em);
	}
	public void add(Passenger passenger) {
		if (passenger == null || passenger.getFirstname() == null || passenger.getLastname() == null)
			return;
		passengerDao.save(passenger);
	}

	public List<Passenger> list() {
		return passengerDao.list(new Passenger ());
		
	}

	
	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();
		//filter.put("name", "sdadad");
		
		List<Passenger> pass = passengerDao.list(filter);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = passengerDao.countAll();
		for(Passenger passenger : pass){
			sb.append(passenger.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	public String load(Long id){
		Passenger passenger = passengerDao.findById(id);
		
		if(passenger != null)
			return passenger.getJson();
		else
			return "{}";
	}

	public boolean delete(Long id) {
		passengerDao.delete(id);
		
		return true;
	}
}