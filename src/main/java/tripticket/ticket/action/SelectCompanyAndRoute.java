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
@WebServlet("/ticket/ticket/*")
public class SelectCompanyAndRoute extends HttpServlet{
	@EJB	
	private CompanyBeanI companyBean;
	
	@EJB
	private RouteBeanI routeBean;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter resp = response.getWriter();
	    
		List<Company> companies = companyBean.list();
	    List<Route> routes = routeBean.list();
	    
	    int num = 1;
	    for(Company company : companies){
        	
	    	
	    	resp.println("<section>");
		    resp.println("<ul id=\"da-thumbs\" class=\"da-thumbs\">");
		    		resp.println("<li>");
		    		resp.println("<a class=\"btn btn-success\"  onclick=\"proceedToTrips()\">Select</a>");
		    				resp.println("<a href=\"images/g-1.jpg\" rel=\"title\" class=\"b-link-stripe b-animate-go  thickbox\">");
		    						resp.println("<img src=\"images/g-"+num+".jpg\" alt=\"\" />");
		    								resp.println("<div>");
		    										resp.println("<h5>"+company.getName()+"</h5>");
		    												resp.println("<span> Click Here to Travel with this company!</span>");
		    								resp.println("</div>");
		    				resp.println("</a>");		    				
		    				
		    		resp.println("</li>");
		    		
					
		    resp.println("</ul>");
		    resp.println("</section>");
		    
		    num++;
	    	
        }
	    
	    
	    
	    
	    
	 
    
	}
}
