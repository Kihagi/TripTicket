package tripticket.vehicle.bean;

import java.util.List;


import tripticket.vehicle.model.Vehicle;

public interface VehicleBeanI {
	void add(Vehicle vehicle);

	List<Vehicle> list();

}
