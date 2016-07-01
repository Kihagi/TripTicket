package tripticket.company.bean;

import java.util.List;

import tripticket.company.model.Company;

public interface CompanyBeanI {

	void add(Company company);
	
	String load(Long id);

	List<Company> list();
	
	boolean delete(Long id);

	String listInJson();

}
