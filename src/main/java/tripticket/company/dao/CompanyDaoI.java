package tripticket.company.dao;

import java.util.List;

import tripticket.company.model.Company;
import tripticket.generic.dao.GenericDaoI;

public interface CompanyDaoI extends GenericDaoI<Company, Long>{
	
	List<Company> active();
	
	List<Company> active2();
	
	Company findByIdNq(Long id);
	
	List<Company> sqlList();
}
