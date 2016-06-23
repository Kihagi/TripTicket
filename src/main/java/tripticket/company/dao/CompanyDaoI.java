package tripticket.company.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tripticket.company.model.Company;

public interface CompanyDaoI {
	
	Company add(Company company);
	
	Company load(Company company);
	
	List<Company> list(Company filter);
	
	void delete(Long companyId);

	void setEm(EntityManager em);

}
