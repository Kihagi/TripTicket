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
		
		PrintWriter writer = resp.getWriter();
	    List<Person> persons = personBean.list();
	    
	    writer.println("<div class=\"text-right\">");
	    writer.println("<a class=\"btn btn-success\"  onclick=\"person.add()\">Add</a>");
	    writer.println("</div>");
        
	    for(Person person : persons){
	    	writer.println("<hr>");
	    	writer.println("<div class=\"row\">");
	    	writer.println("<div class=\"col-md-12\">");
	    	
	    	writer.println(person.getFirstname() + " " + person.getLastname());
	    	
	    	writer.println("<p>"+person.getAddress().getCountry()+"</p>");
	    	writer.println("<p>"+person.getAddress().getFullAddress()+"</p>");
	    	writer.println("<p>"+person.getAddress().getPhoneNo()+"</p>");
	    	writer.println("<p>"+person.getAddress().getTown()+"</p>");
	    	writer.println("</div>");
	    	writer.println("</div>");
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
