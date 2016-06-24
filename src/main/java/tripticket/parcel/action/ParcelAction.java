package tripticket.parcel.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.log4j.Logger;

import tripticket.parcel.bean.ParcelBeanI;
import tripticket.parcel.model.Parcel;

@SuppressWarnings("serial")
@WebServlet("/parcel/action/*")

public class ParcelAction extends HttpServlet{
	
	//private Logger log  = Logger.getLogger(getClass());
	@EJB	
	private ParcelBeanI parcelBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException{
		
		//String [] pathPcl = request.getRequestURI().split("/");
		//String path = pathPcl[pathPcl.length-1];

		this.list(response);
       
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Parcel parcel = new Parcel();
		parcel.setParcelTo(request.getParameter("parcelTo"));
		parcel.setParcelFrom(request.getParameter("parcelFrom"));
		parcel.setParcelDescription(request.getParameter("parcelDescription"));
		parcel.setRoute(request.getParameter("parcelRoute"));
		parcel.setParcelcost(Double.parseDouble(request.getParameter("parcelCost")));
		
		parcelBean.add(parcel);
		
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
	    List<Parcel> parcels = parcelBean.list();
	    
        resp.println("<div class=\"text-right\">");
        resp.println("<a class=\"btn btn-success\"  onclick=\"parcel.add()\">Add Parcel</a>");
        resp.println("</div>");
        for(Parcel parcel : parcels){
	    	resp.println("<hr>");
	    	resp.println("<div class=\"row\">");
	    	resp.println("<div class=\"col-md-12\">");
	    	resp.println("To:  "+parcel.getParcelTo()+" <button class=\"btn btn-small btn-danger pull-right glyphicon glyphicons-bin\">  delete</button>"+"<br>");
	    	resp.println("From:  "+parcel .getParcelFrom()+"<br>");
	    	resp.println("Decription:  "+parcel .getParcelDescription()+"<br>");
	    	resp.println("Route:  "+parcel.getRoute()+"<br>");
	    	resp.println("Cost:  "+ parcel.getParcelcost()+"<br>");
	    	resp.println("</div>");
	    	resp.println("</div>");
	    
	    }
	
	}
	
}
