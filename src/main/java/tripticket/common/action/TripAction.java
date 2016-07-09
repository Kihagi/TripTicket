package tripticket.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;

@SuppressWarnings("serial")
@WebServlet("/trip/*")
public class TripAction extends HttpServlet {
	
	private Trip trip;
	
	@EJB
	private TripBeanI tripBean;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
				String [] pathCmp = request.getRequestURI().split("/");
				String path = pathCmp[pathCmp.length-1];
				
				if(path.equalsIgnoreCase("load"))
					this.load(request, response);
				else
					this.list(response);
			}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Trip trip = new Trip();
		
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			trip.setTripId(Long.parseLong(request.getParameter("id")));
		
		trip.setArrivalTime(request.getParameter("arrivalTime"));
		trip.setDepatureTime(request.getParameter("depatureTime"));
		trip.setRoute(request.getParameter("route"));
		trip.setPrice(Double.parseDouble(request.getParameter("price")));
		
		tripBean.add(trip);
		
	}
	
	
	public void list(HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter resp = response.getWriter();
		resp.println(tripBean.listInJson());
	}
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(tripBean.load(Long.parseLong(request.getParameter("id"))));
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
