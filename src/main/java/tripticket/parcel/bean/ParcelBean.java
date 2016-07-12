package tripticket.parcel.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import trioticket.location.model.Location;
import tripticket.company.dao.CompanyDao;
import tripticket.company.model.Company;
import tripticket.parcel.dao.ParcelDao;
import tripticket.parcel.dao.ParcelDaoI;
import tripticket.parcel.model.Parcel;
import tripticket.route.model.Route;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ParcelBean implements ParcelBeanI{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Inject
	private ParcelDaoI parcelDao;
	
	@PostConstruct
	public void init(){
		parcelDao.setEm(em);
	}

	
	public void add(Parcel parcel){
		/*if(parcel == null || parcel.getParcelTo() == null ||parcel.getParcelFrom() == null)
			return;
		
		//parcelDao.add(parcel);
*/		
		if(parcel == null)
			return;
		
		if(parcel.getFromId() != null)
			parcel.setFrom(em.getReference(Location.class, parcel.getFromId().intValue()));
		
		if(parcel.getToId() != null)
			parcel.setTo(em.getReference(Location.class, parcel.getToId().intValue()));
		
		parcelDao.save(parcel);
	}
	
	public List<Parcel> list(){
		return parcelDao.list(new Parcel());
	}
	


	public boolean delete(Long id) {
		parcelDao.delete(id);
		return true;
	}


	public String listInJson() {
		Map<String, Object> filter = new HashMap<String, Object>();
		
		
		List<Parcel> parcels = parcelDao.list(filter);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = parcelDao.countAll();
		for(Parcel parcel : parcels){
			sb.append(parcel.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
		
	}


	public String load(Long id){
		Parcel parcel = parcelDao.findById(id);
		
		if(parcel != null)
			return parcel.getJson();
		else
			return "{}";
	}	

}
