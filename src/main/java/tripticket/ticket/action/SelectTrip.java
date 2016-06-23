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

import tripticket.ticket.model.SelectVehicleModel;
import tripticket.ticket.bean.SelectVehicleBEANInt;

@SuppressWarnings("serial")
@WebServlet("/companyvehicles")
public class ListCompanyVehiclesAction extends HttpServlet {
	
	@EJB	
	private SelectVehicleBEANInt selectVehicleBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
		List<SelectVehicleModel> vehicles = selectVehicleBean.list();
		
		resp.println("<div class=\"text-center\">");
		resp.println("<h4>Step 2: Now select your favorite Bus and Trip</h4>");
	    resp.println("</div>");
	    
	    for(SelectVehicleModel vehicle : vehicles){
        	resp.println("<hr>");
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	resp.println(vehicle.getVehRegNo() + " : " + vehicle.getVehCapacity()+"<br><br>"+vehicle.getDescription());
	    	//resp.println("<span class=\"pull-right\">10 days ago</span>");
	    	//resp.println("<p>This trip was great in terms of services. I would definitely recomend it to someone else.</p>");
	    	resp.println("<a style=\"float:right\" class=\"btn btn-success\"  onclick=\"ticketBookVehicle()\">Book Now</a>");
	    	resp.println("</div>");
	    	resp.println("</div>");
        }
	}
}
