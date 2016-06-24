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

import tripticket.company.bean.CompanyBeanI;
import tripticket.company.model.Company;
import tripticket.route.bean.RouteBeanI;
import tripticket.route.model.Route;

@SuppressWarnings("serial")
@WebServlet("/ticket")
public class SelectCompanyAndRoute extends HttpServlet{
	@EJB	
	private CompanyBeanI companyBean;
	
	@EJB
	private RouteBeanI routeBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter resp = response.getWriter();
	    
		List<Company> companies = companyBean.list();
	    List<Route> routes = routeBean.list();
	    
	    
	    resp.println("<div class=\"text-left\">");
	    resp.println("<h4>Step 1: Please select your favorite company and Date of Travel</h4>");
        resp.println("</div>");
        resp.println("<hr>");
        
        resp.println("<form action=\"#\" method=\"get\">");
       
        resp.print("<div class=\"form-group\"><label for=\"selectedCompany\">Select Company:</label><br>");
        resp.println("<select name=\"selectedCompany\" id=\"selectedCompany\" required class=\"form-control\">");
        
	        for(Company company : companies){
	        	
		    	resp.println("<option value="+company.getRegNo()+">"+company.getRegNo()+"</option>");
		    	
	        }
        
        resp.println("</select>");
        resp.println("</div>");
        
        resp.print("<div class=\"form-group\"><label for=\"selectedRoute\">Select Route:</label><br>");
        resp.println("<select name=\"selectedRoute\" id=\"selectedRoute\" required class=\"form-control\">");
        
	        for(Route route : routes){
	        	
	        	String location1, location2, fullRoute;
	        	
	        	location1 = "Location"+route.getFromLocationId();
	        	location2 = "Location"+route.getToLocationId();
	        	fullRoute = location1+" to "+location2;
	        	
		    	resp.println("<option value="+fullRoute+">"+fullRoute+"</option>");
		    	
	        }
        
        resp.println("</select>");
        resp.println("</div>");
        
        
        resp.println("<div class=\"form-group\">");
        	resp.println("<label for=\"travelDate\">Date</label>");
        	resp.println("<input type=\"text\" name=\"travelDate\" placeholder=\"yyyy-mm-dd\" class=\"form-control\" required id=\"travelDate\">");
        resp.println("</div>");
        
       
        resp.println("<a class=\"btn btn-success\"  onclick=\"ticket.proceedToTrips()\">Proceed</a>");
       
        
        resp.println("</form>");
	}
}
