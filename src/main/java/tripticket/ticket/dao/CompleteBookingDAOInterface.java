package tripticket.ticket.dao;

import java.util.List;

import tripticket.ticket.model.SelectVehicleModel;

public interface SelectVehicleDAOInterface {
	
	SelectVehicleModel add(SelectVehicleModel vehicle);
	
	SelectVehicleModel load(SelectVehicleModel vehicle);
	
	List<SelectVehicleModel> list(SelectVehicleModel filter);
	
}
