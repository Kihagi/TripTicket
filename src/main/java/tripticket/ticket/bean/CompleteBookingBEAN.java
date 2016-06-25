package tripticket.ticket.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tripticket.ticket.dao.CompleteBookingDAOInterface;
import tripticket.ticket.model.CompleteBookingModel;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompleteBookingBEAN implements CompleteBookingBEANInt {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private CompleteBookingDAOInterface completeBooking;
	
	@PostConstruct
	public void init(){
		completeBooking.setEM(em);
	}
	
	public void add(CompleteBookingModel ticket) {
		if(ticket == null || ticket.getFullname() == null || ticket.getIdNumber() == null || ticket.getPhone() == null)
			return;
		
		completeBooking.add(ticket);
	}

	public List<CompleteBookingModel> list() {
		// TODO Auto-generated method stub
		return completeBooking.list(new CompleteBookingModel());
	}
                           
	
}
