package tripticket.location.action;

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
@WebServlet( "/location/*" )
public class LocationAction extends HttpServlet{
	
	@EJB	
	private LocationBeanI locationBean;
	
	
	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
				String [] locpath = request.getRequestURI().split("/");
				String path = locpath[locpath.length-1];
				this.list(response);
			}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Location location = new Location();
		location.setName(request.getParameter("name"));
		location.setLocNo(request.getParameter("number"));
		location.setDescr(request.getParameter("Description"));
		
		locationBean.add(location);
		
	}
	

	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		
		PrintWriter resp = response.getWriter();
	    List<Location> locations = locationBean.list();
	    
	    resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-info Button\"  onclick=\"tripLocation.remove()\">Show in Maps</a>");
        resp.println("</div>");
        
	    for(Location location : locations){
	    	resp.println("<hr>");
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	resp.println("<p>Our offices can be found: </p>");
	    	resp.println(location.getName() + " : " + location.getId());
	    	resp.println(location.getDescr());
	    	resp.println("</div>");
	    	resp.println("</div>");
	    	
	    	resp.println("<div class=\"text-right\">");
	        resp.println("<a class=\"btn btn-danger\">Delete</a>");
	        resp.println("</div>");
	    	
	    }
	    
	    resp.println("<hr>");
	    resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-info\"  onclick=\"tripLocation.add()\">Add</a>");
        resp.println("</div>");
	}
	

}
