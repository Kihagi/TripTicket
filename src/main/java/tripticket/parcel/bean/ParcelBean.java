package tripticket.parcel.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.parcel.dao.ParcelDaoI;
import tripticket.parcel.model.Parcel;

@Stateless
public class ParcelBean implements ParcelBeanI{
	
	@Inject
	private ParcelDaoI parcelDao;
	
	public void add(Parcel parcel){
		if(parcel == null || parcel.getParcelTo() == null ||parcel.getParcelFrom() == null)
			return;
		
		parcelDao.add(parcel);
	}
	
	public List<Parcel> list(){
		return parcelDao.list(new Parcel());
	}	

}
