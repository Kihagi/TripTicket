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
@WebServlet("/ticket/action/*")
public class CompleteBookingAction extends HttpServlet {
	
	private Logger log = Logger.getLogger(getClass());
	
	@EJB
	private CompleteBookingBEANInt completeBookingBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String[] pathBooking = request.getRequestURI().split("/");
		String path = pathBooking[pathBooking.length-1];
		
		this.list(response);
		
		
	}
	
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
		resp.println("<h4>Thank you for booking!</h4>");
		resp.println("</div>");
		
		for(CompleteBookingModel ticket : tickets){
			resp.println("<hr>");
			resp.println("<div class=\"row\">");
			resp.println("<div class=\"col-md-12\">");
			resp.println("Trip Identification: "+ticket.getTripId()+"<br><br>");
			resp.println("Full Name: "+ticket.getFullname()+"<br><br>");
			resp.println("Cell Phone: "+ticket.getPhone()+"<br><br>");
			resp.println("Seat: "+ticket.getSeat()+"<br><br>");
			resp.println("Identification Number: "+ticket.getIdNumber()+"<br><br>");
			resp.println("</div>");
			resp.println("</div>");
		}
		

	}
}
