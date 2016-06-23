package tripticket.ticket.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import tripticket.company.model.Company;
import tripticket.ticket.model.CompleteBookingModel;

public class CompleteBookingDAO implements CompleteBookingDAOInterface {
	
	private SessionFactory session;
	
	public void add(CompleteBookingModel ticket) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(ticket);
	}
	
	
}
