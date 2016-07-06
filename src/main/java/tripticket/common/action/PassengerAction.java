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

@WebServlet("/passengers/*")
public class PassengerAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private PassengerBeanI passengerBean;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String [] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length-1];
		
		if(path.equalsIgnoreCase("load"))
			this.load(request, response);
		else
			this.list(response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Passenger passenger = new Passenger();
		passenger.setFirstname(req.getParameter("firstname"));
		passenger.setLastname(req.getParameter("lastname"));
		passengerBean.add(passenger);
	}

	private void list(HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter resp = response.getWriter();
		resp.println(passengerBean.listInJson());
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long passengerId = Long.parseLong(request.getParameter("id"));
		passengerBean.delete(passengerId);
		
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(passengerBean.load(Long.parseLong(request.getParameter("id"))));
	}
	
}