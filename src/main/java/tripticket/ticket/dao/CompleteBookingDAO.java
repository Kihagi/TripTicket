package tripticket.ticket.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.ticket.model.CompleteBookingModel;

public class CompleteBookingDAO implements CompleteBookingDAOInterface {
	
	private EntityManager em;
	
	public void setEM(EntityManager em){
		this.em = em;
	}
	
	public CompleteBookingModel add(CompleteBookingModel ticket){
		return em.merge(ticket);
	}
	
	public CompleteBookingModel load(CompleteBookingModel ticket){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<CompleteBookingModel> list (CompleteBookingModel filter){
		return em.createQuery("from CompleteBookingModel t").getResultList();
	}
	
}
