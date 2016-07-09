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

import tripticket.company.model.Company;
import tripticket.trip.model.Trip;
import tripticket.vehicle.bean.VehicleBeanI;
import tripticket.vehicle.model.Vehicle;

@SuppressWarnings("serial")
@WebServlet("/vehicle/*")
public class VehicleAction extends HttpServlet{
	
	private Vehicle vehicle;
	
	@EJB	
	private VehicleBeanI vehicleBean;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
				String [] pathCmp = request.getRequestURI().split("/");
				String path = pathCmp[pathCmp.length-1];
				
				if(path.equalsIgnoreCase("load"))
					this.load(request, response);
				else
					this.list(response);
			}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Vehicle vehicle = new Vehicle();
		
		if(request.getParameter("id") != null 
				&& !request.getParameter("id").equals("undefined"))
			vehicle.setId(Long.parseLong(request.getParameter("id")));
		
		vehicle.setReg_no(request.getParameter("regNo"));
		vehicle.setType(request.getParameter("type"));
		vehicle.setSize(request.getParameter("size"));
		
		vehicleBean.add(vehicle);
		
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Long vehicleId = Long.parseLong(request.getParameter("id"));
		vehicleBean.delete(vehicleId);
		
	}
	
	private void list(HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(vehicleBean.listInJson());
	}
	
	private void load(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException{
		PrintWriter resp = response.getWriter();
        resp.println(vehicleBean.load(Long.parseLong(request.getParameter("id"))));
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	
	
}
