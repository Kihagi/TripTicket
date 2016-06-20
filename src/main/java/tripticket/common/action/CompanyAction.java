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

import tripticket.company.bean.CompanyBeanI;
import tripticket.company.model.Company;

@SuppressWarnings("serial")
@WebServlet("/company")
public class CompanyAction extends HttpServlet{
	
	@EJB	
	private CompanyBeanI companyBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		
		PrintWriter resp = response.getWriter();
	    List<Company> companies = companyBean.list();
	    
        resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"company.add()\">Add</a>");
        resp.println("</div>");
        
	    for(Company company : companies){
	    	resp.println("<hr>");
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println(" <span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star-empty\"></span>");
	    	resp.println(company.getName() + " : " + company.getRegNo());
	    	resp.println("<span class=\"pull-right\">10 days ago</span>");
	    	resp.println("<p>This trip was great in terms of services. I would definitely recomend it to someone else.</p>");
	    	resp.println("</div>");
	    	resp.println("</div>");
	    	
	    	resp.println("<div class=\"text-right\">");
	        resp.println("<a class=\"btn btn-success\"  onclick=\"location.list()\">location</a>");
	        resp.println("</div>");
	    }
	}
	
}
