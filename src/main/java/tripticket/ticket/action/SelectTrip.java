package tripticket.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;

@SuppressWarnings("serial")
@WebServlet("/viewtrips")
public class SelectTrip extends HttpServlet {
	
	@EJB
	private TripBeanI tripBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
		List<Trip> trips = tripBean.list();

		resp.println("<div class=\"text-left\">");
		resp.println("<h4>Step 2: Now select a Trip</h4>");
	    resp.println("</div>");
	    
	    for(Trip trip : trips){
	    	
	    	resp.println("<hr>");
			resp.println("<div class=\"row\">");
			resp.println("<div class=\"col-md-12\">");
			resp.println("<br>");
			resp.println("Trip ID 		: " + trip.getTripId());
			
			resp.println("Depature Time : " + trip.getDepatureTime());
			resp.println("Arrival  Time : " + trip.getArrivalTime());
			resp.println("Route 	 	: " + trip.getRoute());
			resp.println("Vehicle No	: " + trip.getVehicle());
			
			resp.println("<h2> Price : " + trip.getPrice() + "</h2>");
			
			resp.println("<a style=\"float:right\" class=\"btn btn-success\"  onclick=\"ticket.book()\">Book Now</a>");
			resp.println("</div>");
			resp.println("</div>");
	    	
        }
	}
}
