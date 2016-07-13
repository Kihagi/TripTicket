package tripticket.company.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tripticket.company.model.Company;
import tripticket.generic.dao.GenericDao;

public class CompanyDao extends GenericDao<Company, Long> implements CompanyDaoI{

	@SuppressWarnings("unchecked")
	public List<Company> active() {
		Session session = (Session) getEm().getDelegate();
		
		List<Company> companies = session.createCriteria(Company.class)
				.add(Restrictions.isNotNull("name"))
				.list();
		
		return companies;
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> active2() {
		
		List<Company> companies = getEm().createNamedQuery(Company.NQ_ALL)
				.getResultList();
		
		return companies;
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> sqlList() {
		Session session = (Session) getEm().getDelegate();
		
		List<Company> companies = new ArrayList<Company>();
		
		List<Object []> results = session.createSQLQuery("select id, name from comp_companies")
				.list();
		
		Company company;
		for(Object [] result : results){
			company = new Company();
			if(result[0] != null)company.setId( ((BigInteger) result[0]).longValue());
			if(result[1] != null)company.setName( (String) result[1]);
			companies.add(company);
		}
		
		return companies;
	}
	
	@SuppressWarnings("unchecked")
	public Company findByIdNq(Long id) {
		
		List<Company> companies = getEm().createNamedQuery(Company.NQ_FINDBYID)
				.setParameter("id", id)
				.getResultList();
		
		if(companies.isEmpty())
			return null;
		
		return companies.get(0);
	}

}
