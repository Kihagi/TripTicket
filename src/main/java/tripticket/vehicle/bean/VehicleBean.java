package tripticket.vehicle.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.passenger.model.Passenger;
import tripticket.vehicle.dao.VehicleDaoI;
import tripticket.vehicle.model.Vehicle;

@Stateless
public class VehicleBean implements VehicleBeanI {
	
	@PersistenceContext
	private EntityManager em;

	@Inject
	private VehicleDaoI vehicleDao;
	
	@PostConstruct
	public void init(){
		vehicleDao.setEm(em);
	}
	public void add(Vehicle vehicle) {
		if (vehicle == null || vehicle.getReg_no() == null)
			return;

		vehicleDao.save(vehicle);
	}

	public List<Vehicle> list() {
		return vehicleDao.list(new Vehicle());
	}
	
	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();		
		List<Vehicle> vehic = vehicleDao.list(filter);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = vehicleDao.countAll();
		for(Vehicle vehicle : vehic){
			sb.append(vehicle.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	public String load(Long id){
		Vehicle vehicle = vehicleDao.findById(id);
		
		if(vehicle != null)
			return vehicle.getJson();
		else
			return "{}";
	}

	public boolean delete(Long id) {
		vehicleDao.delete(id);
		
		return true;
	}

}
