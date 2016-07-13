package tripticket.ticket.dao;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

import javax.persistence.EntityManager;

public interface GenericDaoI <T, ID extends Serializable>{
	void setEm(EntityManager em);
	EntityManager getEm();
	
	T save(T entity);
	
	List<T> list(T filter); //display everything
	
	List<T> list(Map<String, Object> filter);//search
	
	void delete(ID id);
	
	T findById(Long id);
	
	int countAll();
}
