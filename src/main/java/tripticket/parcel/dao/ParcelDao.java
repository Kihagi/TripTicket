package tripticket.parcel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import tripticket.parcel.model.Parcel;

public class ParcelDao implements ParcelDaoI{
	
	private EntityManager em;

	
	public Parcel add(Parcel parcel) {
		
		return em.merge(parcel);
	}
	
	

	public Parcel load(Parcel parcel) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Parcel> list(Parcel filter) {
		List<Parcel>  parcels = new ArrayList<Parcel>();
		Parcel parcel = new Parcel();
		return em.createQuery("from Parcel p").getResultList();
		
	}

	public void delete(Long parcelId) {
		
	}



	public void setEm(EntityManager em) {
		this.em=em;
		
	}
	
	

}
