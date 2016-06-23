package tripticket.route.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.route.bean.RouteBeanI;
import tripticket.route.model.Route;
import tripticket.route.model.Route;

/*
 * @Sam Kiragu
 */

@SuppressWarnings("Serial")
@WebServlet("/route")
public class RouteAction extends HttpServlet{
	
	@EJB
	private RouteBeanI routeBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		
		PrintWriter resp = response.getWriter();
		List<Route> routes = routeBean.list();
		
		resp.println("<p>Select Your Route from the list given</p>");
        
	    for(Route route : routes){
	    	resp.println("<hr>");
	    	
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");

	    	resp.println("From Location"+route.getFromLocationId()+ " To Location"+route.getToLocationId()+"</br>");
	    	
	    	resp.println("The company is :"+route.getCompanyId()+"</br>");
	    	
	    	resp.println("The approximate distance is : :"+route.getDistance()+"</br>");
	    	
	    	resp.println("The approximate time is :"+route.getApproxTime());
	    	
	    	resp.println("</div>");
	    	resp.println("</div>");
	    	resp.println("<div class=\"text-right\">");
	        resp.println("<a class=\"btn btn-success\"  onclick=\"route.select()\">Select Route</a>");
	        resp.println("</div>");
	    }
		
	}
	
	

}

