package tripticket.passenger.bean;

import java.util.List;

import tripticket.passenger.model.Passenger;

public interface PassengerBeanI {
	
	void add(Passenger passenger);
	
	List <Passenger> list();
	
	String listInJson();
	
	boolean  delete(Long id);
	
	String load(Long id);

}