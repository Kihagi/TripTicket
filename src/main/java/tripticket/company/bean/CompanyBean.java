package tripticket.company.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tripticket.company.dao.CompanyDaoI;
import tripticket.company.model.Company;

@Stateless
public class CompanyBean implements CompanyBeanI{
	
	@Inject
	private CompanyDaoI companyDao;
	
	public void add(Company company){
		if(company == null || company.getName() == null)
			return;
		
		companyDao.add(company);
	}
	
	public List<Company> list(){
		return companyDao.list(new Company());
	}
	
	

}
