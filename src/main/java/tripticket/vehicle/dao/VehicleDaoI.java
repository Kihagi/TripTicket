package tripticket.vehicle.dao;

import java.util.List;


import tripticket.vehicle.model.Vehicle;

public interface VehicleDaoI {
	

	Vehicle add(Vehicle vehicle);
	
	Vehicle load(Vehicle vehicle);
	
	List<Vehicle> list(Vehicle filter);
	
	void delete(Long VehicleId);

}
