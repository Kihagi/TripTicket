package tripticket.parcel.bean;

import java.util.List;

import tripticket.company.model.Company;
import tripticket.parcel.model.Parcel;

public interface ParcelBeanI {

	void add(Parcel parcel);
	
	String load(Long id);

	List<Parcel> list();
	
	boolean delete(Long id);

	String listInJson();

}
