package tripticket.person.dao;

import java.util.List;

import tripticket.person.model.Person;

public interface PersonDaoI {
	
	Person view (Person person);
	
	Person create (Person person);
	
	List <Person> list (Person filter);
	
	void delete (Long personId);
	
	Boolean login (String username, String password);

}