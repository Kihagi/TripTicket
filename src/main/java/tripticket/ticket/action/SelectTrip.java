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

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;

@SuppressWarnings("serial")
@WebServlet("/selecttrip/*")
public class SelectTrip extends HttpServlet {
	
	@EJB
	private TripBeanI tripBean;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length - 1];

		if(path.equalsIgnoreCase("load"))
			this.load(request, response);
		else
			this.list(response);
	}

	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(tripBean.load(Long.parseLong(request.getParameter("id"))));
	}
	
	public void list(HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter resp = response.getWriter();
		resp.println(tripBean.listInJson());
	}
}
