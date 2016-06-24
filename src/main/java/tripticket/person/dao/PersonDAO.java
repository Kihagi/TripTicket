package tripticket.person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.criterion.Restrictions;

import tripticket.common.model.User;
import tripticket.person.model.Person;

public class PersonDAO implements PersonDaoI{
	
	private EntityManager manager;

	public Person view(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	public User create(User user) {
		return manager.merge(user);
	}

	@SuppressWarnings("unchecked")
	public List<Person> list(Person filter) {
		return manager.createQuery("from Person p").getResultList();
	}

	public void delete(Long personId) {
		// TODO Auto-generated method stub
		
	}
	
	public Person create(Person person) {
		return manager.merge(person);
	}

	public Boolean login(String username, String password) {
		

		String hql = "FROM Person p WHERE p.user.username=:username "
				+ "and p.user.password=:pwd";
		Query query = manager.createQuery(hql)
				.setParameter("username", username)
				.setParameter("pwd", password);

		List<Person> results = query.getResultList();

		
		System.out.println(results.isEmpty());
		
		if (results.isEmpty())
			return false;
		else
			return true;
	}

	public void setEm(EntityManager manager) {
		this.manager = manager;
		
	}

	

}
