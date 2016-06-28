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
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
		List<Trip> trips = tripBean.list();

		
	    for(Trip trip : trips){
	    	
	    	resp.println("<section>");
		    resp.println("<ul id=\"da-thumbs\" class=\"da-thumbs\">");
		    		resp.println("<li>");
			    		resp.println("Trip ID 		: " + trip.getTripId());
			    		resp.println("<br>");
						resp.println("Depature Time : " + trip.getDepatureTime());
						resp.println("<br>");
						resp.println("Arrival  Time : " + trip.getArrivalTime());
						resp.println("<br>");
						resp.println("Route 	 	: " + trip.getRoute());
						resp.println("<br>");
						resp.println("Vehicle No	: " + trip.getVehicle());
						
						resp.println("<h2> Fare : $" + trip.getPrice() + "</h2>");
						
						resp.println("<a style=\"float:right\" class=\"btn btn-success\"  onclick=\"ticket.form()\">Book Now</a>");
			    				
		    		resp.println("</li>");
					
		    resp.println("</ul>");
		    resp.println("</section>");
	    	
        }
	}
}
