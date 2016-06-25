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
import tripticket.passenger.bean.PassengerBeanI;
import tripticket.passenger.model.Passenger;

@WebServlet("/passengers/action/*")
public class PassengerAction extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PassengerBeanI passengerBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		this.list(response);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Passenger passenger= new Passenger();
		passenger.setFirstname(req.getParameter("firstname"));
		passenger.setLastname(req.getParameter("lastname"));
		passengerBean.add(passenger);
	}
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		List <Passenger> passengerList= passengerBean.list();

        out.println("<div class=\"text-right\">");
        out.println("<a class=\"btn btn-success glyphicon glyphicon-plus\"  onclick=\"passenger.add()\">  Add</a>");
        out.println("</div>");
	    for(Passenger passenger : passengerList){
	    	out.println("<hr>");
	    	out.println("<div class=\"row\">");
	    	out.println("<div class=\"col-md-12\">");
	    	out.println("First Name:  "+passenger.getFirstname()+" <button class=\"btn btn-small btn-warning pull-right glyphicon glyphicon-trash\">  DELETE</button>"+"<br>");
	    	out.println("Last Name:  "+passenger.getLastname()+"<br>");
	    	out.println("Id Number:  "+ passenger.getId()+"<br>");
	    	out.println("</div>");
	    	out.println("</div>");
	    }
	}

}
