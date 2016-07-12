package tripticket.parcel.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.log4j.Logger;


import tripticket.parcel.bean.ParcelBeanI;
import tripticket.parcel.model.Parcel;

@SuppressWarnings("serial")
@WebServlet("/parcel/*")
public class ParcelAction extends HttpServlet {

	private Parcel parcel;

	@EJB
	private ParcelBeanI parcelBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] pathCmp = request.getRequestURI().split("/");
		String path = pathCmp[pathCmp.length - 1];

		if (path.equalsIgnoreCase("load"))
			this.load(request, response);
		else
			this.list(response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Parcel parcel = new Parcel();

		if (request.getParameter("id") != null
				&& !request.getParameter("id").equals("undefined"))
			parcel.setId(Long.parseLong(request.getParameter("id")));

		if(request.getParameter("fromId") != null 
				&& !request.getParameter("fromId").equals("undefined"))
			parcel.setFromId(Long.parseLong(request.getParameter("fromId")));
		
		if(request.getParameter("toId") != null 
				&& !request.getParameter("toId").equals("undefined"))
			parcel.setToId(Long.parseLong(request.getParameter("toId")));
		
		parcel.setParcelTo(request.getParameter("parcelTo"));
		parcel.setParcelFrom(request.getParameter("parcelFrom"));
		parcel.setParcelDescription(request.getParameter("parcelDescription"));
		parcel.setRoute(request.getParameter("route"));
		parcel.setParcelcost(Double.parseDouble(request
				.getParameter("parcelCost")));

		parcelBean.add(parcel);

	}

	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long ParcelId = Long.parseLong(request.getParameter("id"));
		parcelBean.delete(ParcelId);

	}

	private void list(HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter resp = response.getWriter();
		resp.println(parcelBean.listInJson());
	}

	private void load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter resp = response.getWriter();
		resp.println(parcelBean.load(Long.parseLong(request.getParameter("id"))));
	}

	public Parcel getParcel() {
		return parcel;
	}

	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

}

/*
 * public class ParcelAction extends HttpServlet{ private Parcel parcel;
 * 
 * @EJB company private ParcelBeanI parcelBean;
 * 
 * public void doGet(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException{
 * 
 * String [] pathCmp = request.getRequestURI().split("/"); String path =
 * pathCmp[pathCmp.length-1];
 * 
 * if(path.equalsIgnoreCase("load")) this.load(request, response);
 * 
 * this.list(response);
 * 
 * } private void load(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException{ PrintWriter resp =
 * response.getWriter();
 * resp.println(parcelBean.load(Long.parseLong(request.getParameter("id")))); }
 * public void doPost(HttpServletRequest request, HttpServletResponse response)
 * throws ServletException, IOException{
 * 
 * Parcel parcel = new Parcel(); if(request.getParameter("id") != null &&
 * !request.getParameter("id").equals("undefined"))
 * parcel.setParcelId(Long.parseLong(request.getParameter("id")));
 * 
 * 
 * parcel.setParcelTo(request.getParameter("parcelTo"));
 * parcel.setParcelFrom(request.getParameter("parcelFrom"));
 * parcel.setParcelDescription(request.getParameter("parcelDescription"));
 * parcel.setRoute(request.getParameter("parcelRoute"));
 * parcel.setParcelcost(Double.parseDouble(request.getParameter("parcelCost")));
 * 
 * parcelBean.add(parcel);
 * 
 * 
 * }
 * 
 * private void list(HttpServletResponse response) throws ServletException,
 * IOException{ PrintWriter resp = response.getWriter();
 * resp.println(parcelBean.listInJson());
 * 
 * 
 * resp.println("<div class=\"text-right\">"); resp.println(
 * "<a class=\"btn btn-success\"  onclick=\"parcel.add()\">Add Parcel</a>");
 * resp.println("</div>"); for(Parcel parcel : parcels){ resp.println("<hr>");
 * resp.println("<div class=\"row\">");
 * resp.println("<div class=\"col-md-12\">");
 * resp.println("To:  "+parcel.getParcelTo()+
 * " <button class=\"btn btn-small btn-danger pull-right glyphicon glyphicons-bin\">  delete</button>"
 * +"<br>"); resp.println("From:  "+parcel .getParcelFrom()+"<br>");
 * resp.println("Decription:  "+parcel .getParcelDescription()+"<br>");
 * resp.println("Route:  "+parcel.getRoute()+"<br>"); resp.println("Cost:  "+
 * parcel.getParcelcost()+"<br>"); resp.println("</div>");
 * resp.println("</div>");
 * 
 * }
 * 
 * public void doDelete(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { Long parcelId =
 * Long.parseLong(request.getParameter("id")); parcelBean.delete(parcelId);
 * 
 * } public Parcel getParcel() { return parcel; }
 * 
 * public void setParcel(Parcel parcel) { this.parcel=parcel; }
 * 
 * 
 * 
 * 
 * }
 */