package tripticket.ticket.dao;

import java.util.ArrayList;
import java.util.List;

import tripticket.company.model.Company;
import tripticket.ticket.model.SelectVehicleModel;

public class SelectVehicleDAO implements SelectVehicleDAOInterface {
	
	public SelectVehicleModel add(SelectVehicleModel vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	public SelectVehicleModel load(SelectVehicleModel vehicle) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SelectVehicleModel> list(SelectVehicleModel filter){
		
		List<SelectVehicleModel> vehicles = new ArrayList<SelectVehicleModel>();
		SelectVehicleModel vehicle = new SelectVehicleModel();
		
		vehicle = new SelectVehicleModel();
		vehicle.setVehRegNo("KBZ 162K");
		vehicle.setVehCapacity(54);
		vehicle.setDescription("Departure Time: 7.30PM, Arrival Time: 7.30AM, Route: Nairobi-Mombasa; Fare: Kes. 2400");
		vehicles.add(vehicle);
		
		vehicle = new SelectVehicleModel();
		vehicle.setVehRegNo("KCB 718R");
		vehicle.setVehCapacity(58);
		vehicle.setDescription("Departure Time: 7.30PM, Arrival Time: 7.30AM, Route: Nairobi-Mombasa; Fare: Kes. 1700");
		vehicles.add(vehicle);
		
		vehicle = new SelectVehicleModel();
		vehicle.setVehRegNo("KBK 902X");
		vehicle.setVehCapacity(45);
		vehicle.setDescription("Departure Time: 7.30PM, Arrival Time: 7.30AM, Route: Nairobi-Kakamega; Fare: Kes. 1600");
		vehicles.add(vehicle);
		
		vehicle = new SelectVehicleModel();
		vehicle.setVehRegNo("KBZ 211Z");
		vehicle.setVehCapacity(48);
		vehicle.setDescription("Departure Time: 7.30PM, Arrival Time: 7.30AM, Route: Nairobi-Mombasa; Fare: Kes. 2400");
		vehicles.add(vehicle);
		
		
		return vehicles;
		
	}
}
