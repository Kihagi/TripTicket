package tripticket.company.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import tripticket.common.model.Address;
import tripticket.company.model.Company;

public class CompanyDao implements CompanyDaoI{
	
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Company add(Company company) {
		return em.merge(company);
	}

	public Company load(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Company> list(Company filter) {
		List<Object[]> results = em.createQuery("select c.id,c.name,c.address.email from Company c")
				.getResultList();
		
		List<Company> companies = new ArrayList<Company>();
		Company company;
		for(Object [] result : results){
			company = new Company();
			company.setAddress(new Address());
			
			company.setId(result[0] == null ? null : (Long) result[0]);
			company.setName(result[1] == null ? null : (String) result[1]);
			company.getAddress().setEmail(result[2] == null ? null : (String) result[2]);
			
			companies.add(company);
		}
		
		return companies;
	}

	public void delete(Long companyId) { 
		em.remove(em.find(Company.class, companyId));
	}

}
