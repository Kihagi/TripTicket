package tripticket.passenger.dao;

import java.util.ArrayList;
import java.util.List;

import tripticket.passenger.model.Passenger;

public class PassengerDAO implements PassengerDaoI {

	public Passenger load(Passenger passenger) {
		// TODO Auto-generated method stub
		return null;
	}

	public Passenger add(Passenger passenger) {
		return null;
	}

	public List<Passenger> list(Passenger filter) {
		List <Passenger> passengerList= new ArrayList<Passenger>();
		Passenger passenger =new Passenger();
		passenger.setFirstname("Brian");
		passenger.setLastname("Ndirangu");
		passenger.setId(11111111);
		passengerList.add(passenger);
		
		passenger =new Passenger();
		passenger.setFirstname("Samuel");
		passenger.setLastname("Murani");
		passenger.setId(22222222);
		passengerList.add(passenger);
		
		passenger =new Passenger();
		passenger.setFirstname("Dennis");
		passenger.setLastname("Muoki");
		passenger.setId(33333333);
		passengerList.add(passenger);
		
		passenger =new Passenger();
		passenger.setFirstname("Job");
		passenger.setLastname("Odinga");
		passenger.setId(44444444);
		passengerList.add(passenger);
		
		passenger =new Passenger();
		passenger.setFirstname("Moses");
		passenger.setLastname("Ondiek");
		passenger.setId(55555555);
		passengerList.add(passenger);
		
		
		return passengerList;
	}

	public void delete(Long passengerId) {
		// TODO Auto-generated method stub
		
	}

}
