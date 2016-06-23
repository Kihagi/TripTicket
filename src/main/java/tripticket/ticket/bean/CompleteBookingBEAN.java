package tripticket.ticket.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import tripticket.ticket.dao.CompleteBookingDAOInterface;
import tripticket.ticket.model.CompleteBookingModel;

public class CompleteBookingBEAN implements CompleteBookingBEANInt {
	
	private CompleteBookingDAOInterface completeBooking;
	
	@Transactional
	public void add(CompleteBookingModel ticket) {
		// TODO Auto-generated method stub
		completeBooking.add(ticket);
	}
                           
	
}
