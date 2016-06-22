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

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;

@SuppressWarnings("serial")
@WebServlet("/trips")
public class TripAction extends HttpServlet {

	@EJB
	private TripBeanI tripBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter resp = response.getWriter();
		List<Trip> trips = tripBean.list();

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
		resp.println("<div class=\"text-right\">");
		resp.println("<a class=\"btn btn-info\"  onclick=\"trip.add()\">Create A Trip</a>");
		resp.println("</div>");

	}

}
