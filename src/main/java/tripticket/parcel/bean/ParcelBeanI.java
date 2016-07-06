package tripticket.parcel.bean;

import java.util.List;

import tripticket.parcel.model.Parcel;

public interface ParcelBeanI {

	void add(Parcel parcel);

	List<Parcel> list();
	
	boolean delete (Long id);
	
	String listInJson();

	String load(Long id);

}
