package tripticket.parcel.api;
import javax.ws.rs.Path;

import tripticket.parcel.bean.ParcelBeanI;
import tripticket.parcel.model.Parcel;



@Path("/parcel")
public class ParcelApi {
	
	private ParcelBeanI parcelBean;
	
	@Path("/add")
	public String add(Parcel parcel){
		
		parcelBean.add(parcel);
		
		return "{success: true}";
	}

}
