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

import tripticket.common.model.User;
import tripticket.company.model.Company;
import tripticket.person.bean.PersonBeanI;
import tripticket.person.model.Person;

@SuppressWarnings("serial")
@WebServlet("/person/action/*")
public class PersonAction extends HttpServlet {

	@EJB	
	private PersonBeanI personBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.list(resp);
	
	}

	private void list(HttpServletResponse response) throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
	    List<Person> persons = personBean.list();
	    
        resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"person.add()\">Add</a>");
        resp.println("</div>");
        
	    for(Person person : persons){
	    	resp.println("<hr>");
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println(" <span class=\"glyphicon glyphicon-star\"></span>");
	    	resp.println("<span class=\"glyphicon glyphicon-star-empty\"></span>");
	    	resp.println(person.getFirstname()+ person.getLastname() + " : " + person.getId());
	    	
	    	resp.println("</div>");
	    	resp.println("</div>");
	    	
	    	resp.println("<div class=\"text-right\">");
	    	resp.println("<a class=\"btn btn-danger\"  onclick=\"person.remove(" + person.getId() + ")\">Delete</a><br/>");
	        resp.println("<span class=\"pull-right\">Status: Active</span>");
	        resp.println("</div>");
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User();
		user.setPassword(req.getParameter("password"));
		user.setUsername(req.getParameter("username"));
		
		Person person  = new Person();
		person.setFirstname(req.getParameter("fname"));
		person.setLastname(req.getParameter("lname"));
		person.setId(req.getParameter("id"));;
		person.setUser(user);
		
		PrintWriter writer = resp.getWriter();
		
		try{
			personBean.create(person);
			
			writer.println("<p>Registration successful, please log in</p>");		
			
		}
		catch(Exception e)
		{
			writer.println("<p>An error occured: "+e.getMessage()+"</p>");
			
		}
		
		
	}
	
	
	

}
