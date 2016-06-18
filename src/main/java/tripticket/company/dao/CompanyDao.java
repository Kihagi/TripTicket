package tripticket.company.dao;

import java.util.ArrayList;
import java.util.List;

import tripticket.company.model.Company;

public class CompanyDao implements CompanyDaoI{

	public Company add(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	public Company load(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Company> list(Company filter) {
		List<Company>  companies = new ArrayList<Company>();
		Company company = new Company();
		
		company.setName("Modern Cost");
		company.setRegNo("MC-1");
		companies.add(company);
		
		company = new Company();
		company.setName("Horizon");
		company.setRegNo("HR-1");
		companies.add(company);
		
		company = new Company();
		company.setName("Mash Poa");
		company.setRegNo("MP-1");
		companies.add(company);
		
		company = new Company();
		company.setName("Spanish");
		company.setRegNo("SP-1");
		companies.add(company);
		
		company = new Company();
		company.setName("Mbukinya");
		company.setRegNo("Mk-1");
		companies.add(company);
		
		company = new Company();
		company.setName("Easy Coach");
		company.setRegNo("EC-1");
		companies.add(company);
		
		return companies;
	}

	public void delete(Long companyId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
