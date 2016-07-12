package tripticket.person.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.person.dao.PersonDaoI;
import tripticket.person.model.Person;

@Stateless
public class PersonBean implements PersonBeanI {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Inject
	private PersonDaoI personDao;
	
	@PostConstruct
	public void init(){
		personDao.setEm(manager);
	}

	public void create(Person person) {
		if(person == null)
			return;
		
		personDao.save(person);
	}

	public Boolean login(String username, String password) {
		
		Boolean authentication = personDao.login(username, password);
		if(authentication == true){
			return true;			
		}
		else
		{
			
			return false;			
		}
		
	}

	public List<Person> list() {
		//
		return personDao.list(new Person());
	}

}
