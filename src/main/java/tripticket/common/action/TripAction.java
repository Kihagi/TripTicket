package tripticket.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;

@SuppressWarnings("serial")
@WebServlet("/trips/action/*")
public class TripAction extends HttpServlet {
	
	private Logger log  = Logger.getLogger(getClass());

	@EJB
	private TripBeanI tripBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
				String [] pathCmp = request.getRequestURI().split("/");
				String path = pathCmp[pathCmp.length-1];
				this.list(response);
			}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Trip trip = new Trip();
		trip.setDepatureTime(request.getParameter("depatureDate"));
		trip.setArrivalTime(request.getParameter("arrivalDate"));
		trip.setRoute(request.getParameter("route"));
		trip.setVehicle(request.getParameter("vehicle"));
		trip.setPrice(Double.parseDouble(request.getParameter("price")));
		
		tripBean.add(trip);
		
	}
	
	
	public void list(HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter resp = response.getWriter();
		List<Trip> trips = tripBean.list();
		
		resp.println("<div class=\"text-right\">");
		resp.println("<a class=\"btn btn-info\"  onclick=\"trip.add()\">Create A Trip</a>");
		resp.println("</div>");


		for (Trip trip : trips) {
			resp.println("<hr>");
			resp.println("<div class=\"row\">");
			resp.println("<div class=\"col-md-12\">");
			resp.println("<br>");
			resp.println("Trip ID 		: " + trip.getTripId());
			resp.println("<br>___________________________________________________________________");
			resp.println("<br>" + "Depature Time : " + trip.getDepatureTime());
			resp.println("<br>" + "Arrival  Time : " + trip.getArrivalTime());
			resp.println("<br>" + "Route 	 	: " + trip.getRoute());
			resp.println("<br>" + "Vehicle No	: " + trip.getVehicle());
			resp.println("<br>___________________________________________________________________");
			resp.println("<br><h2> Price : " + trip.getPrice() + "</h2>");
			resp.println("<br>___________________________________________________________________");
			resp.println("</div>");
			resp.println("</div>");
			
			
		}
		
	}

}
