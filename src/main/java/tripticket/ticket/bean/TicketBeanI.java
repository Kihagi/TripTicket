package tripticket.ticket.bean;

import java.util.List;

import tripticket.ticket.model.Ticket;

public interface TicketBeanI {
	void add(Ticket ticket);
	
	String load(Long id);
	
	List<Ticket> list();
	
	boolean delete(Long id);
	
	String listInJson();
}
