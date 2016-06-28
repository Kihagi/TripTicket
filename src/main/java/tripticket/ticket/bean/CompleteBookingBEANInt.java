package tripticket.ticket.bean;

import java.util.List;

import tripticket.ticket.model.CompleteBookingModel;

public interface CompleteBookingBEANInt {
	void add(CompleteBookingModel ticket);
	
	List<CompleteBookingModel> list();
	
	void delete(Long ticketId);
}
