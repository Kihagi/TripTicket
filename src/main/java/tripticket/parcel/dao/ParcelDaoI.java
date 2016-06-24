package tripticket.parcel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.parcel.model.Parcel;

public interface ParcelDaoI {
	
	Parcel add(Parcel parcel);
	
	Parcel load(Parcel parcel);
	
	List<Parcel> list(Parcel filter);
	
	void delete(Long parcelId);

	void setEm(EntityManager em);
	

}
