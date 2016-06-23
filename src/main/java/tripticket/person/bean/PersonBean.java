package tripticket.person.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.person.dao.PersonDaoI;
import tripticket.person.model.Person;

@Stateless
public class PersonBean implements PersonBeanI {
	
	@Inject
	private PersonDaoI personDao;

	public void create(Person person) {
		// TODO Auto-generated method stub
		
	}

	public Boolean login(String username, String password) {
		
		if(username.equals("") || password.equals("")){
			return false;			
		}
		else
		{
			personDao.login(username, password);
			return true;			
		}
		
	}

	public List<Person> list() {
		//
		return personDao.list(new Person());
	}

}
