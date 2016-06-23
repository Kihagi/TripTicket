package tripticket.company.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.company.dao.CompanyDaoI;
import tripticket.company.model.Company;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompanyBean implements CompanyBeanI{
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private CompanyDaoI companyDao;
	
	@PostConstruct
	public void init(){
		companyDao.setEm(em);
	}
	
	public void add(Company company){
		if(company == null || company.getName() == null)
			return;
		
		companyDao.add(company);
	}
	
	public List<Company> list(){
		return companyDao.list(new Company());
	}	

}
