package tripticket.route.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import tripticket.company.model.Company;
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
		/*if (request.getParameter("id") !=null
				&& !request.getParameter("id").equals("undefined"))
				route.setToLocationId(Long.parseLong(request.getParameter("id")));
		
		
			route.setApproxTime(Double.parseDouble(request.getParameter("ApproxTime")));
			route.setCompanyId(Long.parseLong(request.getParameter("companyId")));
			route.setDistance(Double.parseDouble(request.getParameter("distance")));
			route.setFromLocationId(Long.parseLong(request.getParameter("fromLocationId")));
			route.setToLocationId(Long.parseLong(request.getParameter("toLocationId")));*/
			
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
