package tripticket.person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.criterion.Restrictions;

import tripticket.common.model.User;
import tripticket.generic.dao.GenericDao;
import tripticket.person.model.Person;

public class PersonDAO extends GenericDao <Person, Long> implements PersonDaoI{

	public Boolean login(String username, String password) {
		

		String hql = "FROM Person p WHERE p.user.username=:username "
				+ "and p.user.password=:pwd";
		Query query = em.createQuery(hql)
				.setParameter("username", username)
				.setParameter("pwd", password);

		List<Person> results = query.getResultList();

		
		System.out.println(results.isEmpty());
		
		if (results.isEmpty())
			return false;
		else
			return true;
	}

	

}
