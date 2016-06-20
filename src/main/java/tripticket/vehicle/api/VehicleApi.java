package tripticket.vehicle.api;

import javax.ws.rs.Path;

import tripticket.vehicle.bean.VehicleBeanI;
import tripticket.vehicle.model.Vehicle;

@Path("/vehicle")
public class VehicleApi {
	private VehicleBeanI vehicleBean;

	@Path("/add")
	public String add(Vehicle vehicle) {

		vehicleBean.add(vehicle);

		return "{success: true}";
	}

}
