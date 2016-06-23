package tripticket.person.dao;

import java.util.ArrayList;
import java.util.List;

import tripticket.common.model.Address;
import tripticket.person.model.Person;
import tripticket.vehicle.model.Vehicle;

public class PersonDAO implements PersonDaoI{

	public Person view(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person create(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> list(Person filter) {
		List<Person> persons = new ArrayList<Person>();
		
		Address adress = new Address();
		adress.setCountry("Germany");
		adress.setEmail("hitler@gmail.com");
		adress.setFullAddress("Ong Bak Road, 7th Avenue");
		adress.setPhoneNo("0713653112");
		adress.setTown("Sin City");
		
		Person person = new Person();
		
		person.setFirstname("Adolf");
		person.setLastname("Hitler");
		person.setAddress(adress);
		persons.add(person);
		
		person = new Person();
		
		person.setFirstname("Adolf");
		person.setLastname("Hitler");
		person.setAddress(adress);
		persons.add(person);
		
		
		person = new Person();
		
		person.setFirstname("Adolf");
		person.setLastname("Hitler");
		person.setAddress(adress);
		persons.add(person);
		
		person = new Person();
		
		person.setFirstname("Adolf");
		person.setLastname("Hitler");
		person.setAddress(adress);
		persons.add(person);
		
		person = new Person();
		
		person.setFirstname("Adolf");
		person.setLastname("Hitler");
		person.setAddress(adress);
		persons.add(person);
		
		return persons;
		
	}

	public void delete(Long personId) {
		// TODO Auto-generated method stub
		
	}

	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
