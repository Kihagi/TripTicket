package tripticket.route.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tripticket.company.model.Company;
import tripticket.route.bean.RouteBeanI;
import tripticket.route.model.Route;
import tripticket.route.model.Route;

/*
 * @Sam Kiragu
 */

@SuppressWarnings("Serial")
@WebServlet("/route/*")
public class RouteAction extends HttpServlet{
	
	private Logger log  = Logger.getLogger(getClass());
	
	@EJB
	private RouteBeanI routeBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
			String [] pathRmp = request.getRequestURI().split("/");
			String path = pathRmp[pathRmp.length-1];
		
			this.list(response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Route route = new Route();	
		if (request.getParameter("id") !=null
				&& !request.getParameter("id").equals("undefined"))
				route.setToLocationId(Long.parseLong(request.getParameter("id")));
		
		
			route.setApproxTime(Double.parseDouble(request.getParameter("ApproxTime")));
			route.setCompanyId(Long.parseLong(request.getParameter("companyId")));
			route.setDistance(Double.parseDouble(request.getParameter("distance")));
			route.setFromLocationId(Long.parseLong(request.getParameter("fromLocationId")));
			route.setToLocationId(Long.parseLong(request.getParameter("toLocationId")));
			
			routeBean.add(route);
			
			
	}
		
		
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(routeBean.listInJson());
			
	    
/*	    resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"route.form()\">Add Route</a>");
        resp.println("</div>");
        
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
	    	
	    }*/
		
	}
	@SuppressWarnings("unused")
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(routeBean.load(Long.parseLong(request.getParameter("id"))));
	}

/*	public Route getCompany() {
		return Route;
	}

	public void setRoute(Route route {
		this.route = route;
	}*/
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long routeId = Long.parseLong(request.getParameter("id"));
		routeBean.delete(routeId);
		
	}
	
	

}
