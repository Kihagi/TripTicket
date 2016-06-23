package tripticket.person.bean;

import java.util.List;

import tripticket.person.model.Person;
import tripticket.vehicle.model.Vehicle;


public interface PersonBeanI {

	void create(Person person);
	
	Boolean login (String username, String password);
	List<Person> list();

}
