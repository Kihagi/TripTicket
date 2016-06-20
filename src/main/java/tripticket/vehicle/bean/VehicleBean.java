package tripticket.vehicle.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.vehicle.dao.VehicleDaoI;
import tripticket.vehicle.model.Vehicle;

@Stateless
public class VehicleBean implements VehicleBeanI {

	@Inject
	private VehicleDaoI vehicleDao;

	public void add(Vehicle vehicle) {
		if (vehicle == null || vehicle.getReg_no() == null)
			return;

		vehicleDao.add(vehicle);
	}

	public List<Vehicle> list() {
		return vehicleDao.list(new Vehicle());
	}

}
