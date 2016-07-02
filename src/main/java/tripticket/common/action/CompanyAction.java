package tripticket.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.company.bean.CompanyBeanI;
import tripticket.company.model.Company;

@SuppressWarnings("serial")
@WebServlet("/company/*")
public class CompanyAction extends HttpServlet{
	
	@EJB	
	private CompanyBeanI companyBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		if(path.equalsIgnoreCase("load"))
			this.load(request, response);
		else
			this.list(response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Company company = new Company();
		
		if(request.getParameter("id") != null)
			company.setId(Long.parseLong(request.getParameter("id")));
		
		company.setName(request.getParameter("name"));
		company.setRegNo(request.getParameter("regNo"));
		
		companyBean.add(company);
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long companyId = Long.parseLong(request.getParameter("id"));
		companyBean.delete(companyId);
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(companyBean.listInJson());
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(companyBean.load(Long.parseLong(request.getParameter("id"))));
	}
	
}
