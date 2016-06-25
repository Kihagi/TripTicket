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

import org.apache.log4j.Logger;

import tripticket.company.bean.CompanyBeanI;
import tripticket.company.model.Company;

@SuppressWarnings("serial")
@WebServlet("/company/action/*")
public class CompanyAction extends HttpServlet{
	
	private Logger log  = Logger.getLogger(getClass());
	
	@EJB	
	private CompanyBeanI companyBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
/*		
		if(path.equalsIgnoreCase("add"))
			this.add(request, response);
		else*/
		this.list(response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setRegNo(request.getParameter("regNo"));
		
		companyBean.add(company);
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long companyId = Long.parseLong(request.getParameter("id"));
		System.out.println("what is the ID ====================== " + companyId);
		companyBean.delete(companyId);
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
	    List<Company> companies = companyBean.list();
	    
        resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"companyX.form()\">Add</a>");
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
	    	resp.println("<a class=\"btn btn-danger\"  onclick=\"company.remove(" + company.getId() + ")\">Delete</a>");
	        resp.println("<a class=\"btn btn-success\"  onclick=\"tripLocation.list()\">location</a>");
	        resp.println("</div>");
	    }
	
	}
	
}
