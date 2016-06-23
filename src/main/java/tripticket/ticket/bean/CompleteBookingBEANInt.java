package tripticket.ticket.bean;

import java.util.List;

import tripticket.ticket.model.SelectVehicleModel;

public interface SelectVehicleBEANInt {
	
	void add(SelectVehicleModel vehicle);
	
	List<SelectVehicleModel> list();
}
