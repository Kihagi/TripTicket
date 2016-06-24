package tripticket.common.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tripticket.person.bean.PersonBeanI;

@SuppressWarnings("serial")
@WebServlet("/welcome")
public class WelcomeAction extends HttpServlet {

	@EJB	
	private PersonBeanI personBean;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter response = resp.getWriter();
		Boolean loginStatus;
		
		RequestDispatcher rq = req.getRequestDispatcher("index.jsp");
		//rq.forward(req, resp);
		
	
	
		
		
		try{
			loginStatus = personBean.login(username, password);
			
			if(loginStatus == true)
			{
				
			
				rq.forward(req, resp);
				response.println("<p>Ilogin succesful</p>");
				
			}
			else
			{
				response.println("<p>Invalid login credentials</p>");
			}
			
			
			
		}
		catch(Exception e)
		{
			response.println("<p>An error occured: "+e.getMessage()+"</p>");
			
		}

		
	}
	
	

}
