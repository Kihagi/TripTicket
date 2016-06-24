package tripticket.parcel.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.parcel.dao.ParcelDaoI;
import tripticket.parcel.model.Parcel;

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
		if(parcel == null || parcel.getParcelTo() == null ||parcel.getParcelFrom() == null)
			return;
		
		parcelDao.add(parcel);
	}
	
	public List<Parcel> list(){
		return parcelDao.list(new Parcel());
	}	

}
