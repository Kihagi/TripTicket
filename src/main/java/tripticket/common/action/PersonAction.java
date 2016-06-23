package tripticket.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tripticket.person.bean.PersonBeanI;
import tripticket.person.model.Person;
import tripticket.vehicle.model.Vehicle;

@SuppressWarnings("serial")
@WebServlet("/person")
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
	

}
