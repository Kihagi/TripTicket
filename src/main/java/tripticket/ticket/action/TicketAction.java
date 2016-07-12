package tripticket.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.ticket.bean.TicketBeanI;
import tripticket.ticket.model.Ticket;

@SuppressWarnings("serial")
@WebServlet("/booking")
public class TicketAction extends HttpServlet{
	private Ticket ticket;
	
	@EJB
	private TicketBeanI ticketBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		if(path.equalsIgnoreCase("load"))
			this.load(request, response);
		else
			this.list(response);
	}
	
	//list of tickets
	private void list(HttpServletResponse response) throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
		resp.println(ticketBean.listInJson());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Ticket ticket = new Ticket();
		
		if(request.getParameter("tripId") != null && !request.getParameter("tripId").equals("undefined"))
		
			ticket.setFullname(request.getParameter("fullname"));
			ticket.setIdNumber(request.getParameter("idNumber"));
			ticket.setPhone(request.getParameter("phone"));
			ticket.setSeat(request.getParameter("seat"));
			int trip = Integer.parseInt(request.getParameter("tripId"));
			
			ticket.setTripId(trip);
			
			System.out.println("fucnkjed");
			
			ticketBean.add(ticket);
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long ticketId = Long.parseLong(request.getParameter("id"));
		ticketBean.delete(ticketId);
	}
	
	public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(ticketBean.load(Long.parseLong(request.getParameter("id"))));
	}
	
	public Ticket geTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}
