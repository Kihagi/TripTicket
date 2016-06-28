package tripticket.ticket.action;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tripticket.ticket.bean.CompleteBookingBEANInt;
import tripticket.ticket.model.CompleteBookingModel;

@SuppressWarnings("serial")
@WebServlet("/bookings")
public class CompleteBookingAction extends HttpServlet {
	
	private Logger log = Logger.getLogger(getClass());
	
	@EJB
	private CompleteBookingBEANInt completeBookingBean;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String[] pathBooking = request.getRequestURI().split("/");
		String path = pathBooking[pathBooking.length-1];
		
		this.list(response);
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CompleteBookingModel booking = new CompleteBookingModel();
		booking.setFullname(request.getParameter("name").toUpperCase());
		booking.setIdNumber(request.getParameter("idNumber").toUpperCase());
		booking.setPhone(request.getParameter("phone").toUpperCase());
		
		int seat = Integer.parseInt(request.getParameter("seat").toString());
		
		booking.setSeat(seat);
		
		int trip = Integer.parseInt(request.getParameter("tripId"));
		
		booking.setTripId(trip);
		
		completeBookingBean.add(booking);
		
	}
	
	private void list(HttpServletResponse response)	throws ServletException, IOException {
		PrintWriter resp = response.getWriter();
		List<CompleteBookingModel> tickets = completeBookingBean.list();

		resp.println("<div class=\"text-center\">");
		resp.println("<h4>Bookings Made!</h4>");
		resp.println("</div>");
		
		resp.println("<table id='transactions' class='table table-striped responsive-utilities jambo_table' style='font-size:11px'>");
		resp.println("<thead>");
			resp.println("<tr class='headings'>");
			resp.println("<tr class='headings'>"
					+ "<th>National Id</th>"
					+ "<th>Full Name</th>"
					+ "<th>Phone</th>"
					+ "<th>Seat No</th>"
					+ "<th>Trip Id</th>"
					+ "<th class='no-link last'><span class='nobr'>Action</span></th>"
					+ "</tr>"
					+ "</thead>");
			
			resp.println("<tbody style='font-size:12px'>");
			
			for(CompleteBookingModel ticket : tickets){
				resp.println("<tr>");
				
				resp.println("<td>"+ticket.getIdNumber()+"</td>");
				resp.println("<td>"+ticket.getFullname()+"</td>");
				resp.println("<td>"+ticket.getPhone()+"</td>");
				resp.println("<td>"+ticket.getSeat()+"</td>");
				resp.println("<td>"+ticket.getTripId()+"</td>");
				resp.println("<td><a class=\"btn btn-danger\"  onclick=\"ticket.deleteEntry(" + ticket.getId() + ")\">Cancel</a></td>");
				resp.println("</tr>");
			}
		
		resp.println("</tbody>");
		resp.println("</table>");
		

	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Long ticketId = Long.parseLong(request.getParameter("id"));
		completeBookingBean.delete(ticketId);
	}
	
}
