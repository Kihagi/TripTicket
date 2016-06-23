package tripticket.ticket.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.ticket.dao.SelectVehicleDAOInterface;
import tripticket.ticket.model.SelectVehicleModel;

@Stateless
public class SelectVehicleBEAN implements SelectVehicleBEANInt {
	
	@Inject
	private SelectVehicleDAOInterface selectVehicleDao;
	
	public void add(SelectVehicleModel vehicle){
		if(vehicle == null || vehicle.getVehRegNo() == null)
			return;
		
		selectVehicleDao.add(vehicle);
	}
	
	public List<SelectVehicleModel> list(){
		return selectVehicleDao.list(new SelectVehicleModel());
	}
	
}
