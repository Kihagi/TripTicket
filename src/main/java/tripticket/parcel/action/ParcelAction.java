package tripticket.parcel.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripticket.parcel.bean.ParcelBeanI;
import tripticket.parcel.model.Parcel;

@SuppressWarnings("serial")
@WebServlet("/parcel")
public class ParcelAction extends HttpServlet{
	
	@EJB	
	private ParcelBeanI parcelBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
	    	resp.println("Decription:  "+parcel .getParcelFrom()+"<br>");
	    	resp.println("Route:  "+parcel.getRoute()+"<br>");
	    	resp.println("Cost:  "+ parcel.getParcelcost()+"<br>");
	    	resp.println("</div>");
	    	resp.println("</div>");
	    }
	}
	
}
