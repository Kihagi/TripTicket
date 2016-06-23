package tripticket.company.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
		return em.createQuery("from Company c").getResultList();
	}

	public void delete(Long companyId) {
		// TODO Auto-generated method stub
		
	}

}
