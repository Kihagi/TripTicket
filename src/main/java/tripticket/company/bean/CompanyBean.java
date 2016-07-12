package tripticket.company.bean;

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
		
		companyDao.save(company);
	}
	
	public String load(Long id){
		Company company = companyDao.findByIdNq(id);
		
		if(company != null)
			return company.getJson();
		else
			return "{}";
	}
	
	public List<Company> list(){
		return companyDao.list(new Company());
	}
	
	public String listInJson(){
		Map<String, Object> filter = new HashMap<String, Object>();
		//filter.put("name", "sdadad");
		
		//List<Company> companies = companyDao.list(filter);
		List<Company> companies = companyDao.sqlList();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		int count = companyDao.countAll();
		for(Company company : companies){
			sb.append(company.getJson());
			
			count--;
			
			if(count >= 1)
				sb.append(",");
		}
		
		sb.append("]");
		
		return sb.toString();
	}

	public boolean delete(Long id) {
		companyDao.delete(id);
		
		return true;
	}	

}
