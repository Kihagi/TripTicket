package tripticket.route.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.route.bean.RouteBeanI;
import tripticket.route.model.Route;

/*
 * @Sam Kiragu
 */

@SuppressWarnings("serial")
@WebServlet("/route/*")
public class RouteAction extends HttpServlet{
	
	@EJB
	private RouteBeanI routeBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
			String [] pathRmp = request.getRequestURI().split("/");
			String path = pathRmp[pathRmp.length-1];
			
			if(path.equalsIgnoreCase("load"))
				this.load(request, response);
			else
				this.list(response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Route route = new Route();	
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			route.setId(Long.parseLong(request.getParameter("id")));
		
		if(request.getParameter("fromId") != null 
				&& !request.getParameter("fromId").equals("undefined"))
			route.setFromId(Long.parseLong(request.getParameter("fromId")));
		
		if(request.getParameter("toId") != null 
				&& !request.getParameter("toId").equals("undefined"))
			route.setToId(Long.parseLong(request.getParameter("toId")));
		
		route.setApproxTime(Double.parseDouble(request.getParameter("approxTime")));
		route.setDistance(Double.parseDouble(request.getParameter("distance")));
			
		routeBean.add(route);
			
			
	}
		
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(routeBean.listInJson());
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(routeBean.load(Long.parseLong(request.getParameter("id"))));
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long routeId = Long.parseLong(request.getParameter("id"));
		routeBean.delete(routeId);
		
	}

}
