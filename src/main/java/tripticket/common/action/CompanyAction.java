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

@SuppressWarnings("serial")
@WebServlet("/company")
public class CompanyAction extends HttpServlet{
	
	@EJB	
	private CompanyBeanI companyBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
		resp.println("Company Stuff will be here!");
	}
	
}
