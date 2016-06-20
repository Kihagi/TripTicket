package tripticket.commlocation.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trioticket.location.model.Location;
import tripticket.location.bean.LocationBeanI;

@SuppressWarnings("serial")
@WebServlet( "./location" )
public class LocationAction extends HttpServlet{
	
	@EJB	
	private LocationBeanI LocationBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		
		PrintWriter resp = response.getWriter();
	    List<Location> locations = LocationBean.list();
	    
        resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"location.add()\">Add</a>");
        resp.println("</div>");
        
	    for(Location location : locations){
	    	resp.println("<hr>");
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	resp.println(location.getName() + " : " + location.getId());
	    	resp.println("</div>");
	    	resp.println("</div>");
	    	
	    	resp.println("<div class=\"text-right\">");
	        resp.println("<a class=\"btn btn-success\"  onclick=\"location.add()\">Show in Maps</a>");
	        resp.println("</div>");
	    }
	}
	

}
