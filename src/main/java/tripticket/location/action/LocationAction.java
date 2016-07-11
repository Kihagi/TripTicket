package tripticket.location.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trioticket.location.model.Location;
import tripticket.location.bean.LocationBeanI;

@SuppressWarnings("serial")
@WebServlet( "/location/*" )
public class LocationAction extends HttpServlet{
	
	@EJB	
	private LocationBeanI locationBean;
	
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
		
		Location location = new Location();
		
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			
			location.setId(Integer.parseInt(request.getParameter("id")));
		
		location.setName(request.getParameter("name"));
		location.setLocNo(request.getParameter("number"));
		location.setDescr(request.getParameter("Description"));
		
		locationBean.add(location);
		
	}
		
		public void doDelete(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException{
			int locationId = Integer.parseInt(request.getParameter("id"));
			locationBean.delete(locationId);
			
	}
		
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(locationBean.listInJson());
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(locationBean.load(Integer.parseInt(request.getParameter("id"))));
	}
	

}
