package tripticket.trip.soapapi;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import tripticket.trip.bean.TripBeanI;
import tripticket.trip.model.Trip;


@WebService(serviceName = "tripws")
public class TripWs{
	
	@EJB
	private TripBeanI tripBean;
	
	@WebMethod
	public List<Trip> list(){
		return tripBean.list();
	}
	
	@WebMethod
	public Trip load(){
		List<Trip> trips = tripBean.list();
		
		if(trips.isEmpty())
			return new Trip();
		else
			return trips.get(0);
	}
	
}