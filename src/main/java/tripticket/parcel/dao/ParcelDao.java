package tripticket.parcel.dao;

import java.util.ArrayList;
import java.util.List;

import tripticket.parcel.model.Parcel;

public class ParcelDao implements ParcelDaoI{

	public Parcel add(Parcel parcel) {
		
		return null;
	}
	
	

	public Parcel load(Parcel parcel) {
		
		return null;
	}

	public List<Parcel> list(Parcel filter) {
		List<Parcel>  parcels = new ArrayList<Parcel>();
		Parcel parcel = new Parcel();
		
		parcel.setParcelTo("Samuel");
		parcel.setParcelFrom("Brian Ndirangu");
		parcel.setParcelDescription("LED TV");
		parcel.setParcelcost(1200.00);
		parcels.add(parcel);
		
		parcel = new Parcel();
		parcel.setParcelTo("Mfuon");
		parcel.setParcelFrom("Dennis");
		parcel.setParcelDescription("Laptop");
		parcel.setParcelcost(600.00);
		parcels.add(parcel);
		
		parcel = new Parcel();
		parcel.setParcelTo("Saamuel Kiragu");
		parcel.setParcelFrom("Job Oginga");
		parcel.setParcelDescription("Phone");
		parcel.setParcelcost(300.00);
		parcels.add(parcel);
		
		parcel = new Parcel();
		parcel.setParcelTo("Dancun");
		parcel.setParcelFrom("Mosses");
		parcel.setParcelDescription("Maize Floor");
		parcel.setParcelcost(200.00);
		parcels.add(parcel);
		
		parcel = new Parcel();
		parcel.setParcelTo("Bavon Mike");
		parcel.setParcelFrom("John Doe");
		parcel.setParcelDescription("Certificates");
		parcel.setParcelcost(500.00);
		parcels.add(parcel);
		
		parcel = new Parcel();
		parcel.setParcelTo("Mfuon");
		parcel.setParcelFrom("Dancun");
		parcel.setParcelDescription("Beans");
		parcel.setParcelcost(400.00);
		parcels.add(parcel);
		
		return parcels;
	}

	public void delete(Long parcelId) {
		
	}
	
	

}
