package tripticket.ticket.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.ticket.model.CompleteBookingModel;

public interface CompleteBookingDAOInterface {
	
	CompleteBookingModel add(CompleteBookingModel ticket);
	CompleteBookingModel load(CompleteBookingModel ticket);
	
	void setEM(EntityManager em);

	List<CompleteBookingModel> list(CompleteBookingModel filter); 
	
	void delete(Long ticketId);
}
