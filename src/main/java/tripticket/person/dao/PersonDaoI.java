package tripticket.person.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.generic.dao.GenericDaoI;

import tripticket.person.model.Person;

public interface PersonDaoI extends GenericDaoI<Person, Long>{

	Boolean login (String username, String password);


}
