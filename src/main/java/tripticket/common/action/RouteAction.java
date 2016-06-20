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

import tripticket.company.bean.RouteBeanI;
import tripticket.company.model.Company;
import tripticket.company.model.Route;

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
		
		resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"route.add()\">Add Route</a>");
        resp.println("</div>");
        
	    for(Route route : routes){
	    	resp.println("<hr>");
	    	
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	/*
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println(" <span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star-empty\"></span>");
	    	*/
	    	resp.println("From Location"+route.getFromLocationId()+ " To Location"+route.getToLocationId());
	    	resp.println("<span class=\"pull-right\">10 days ago</span>");
	    	resp.println("<p>This route is short and the road is very good. I would definitely recomend it to someone else.</p>");
	    	resp.println("</div>");
	    	resp.println("</div>");
	    }
		
	}
	
	

}
