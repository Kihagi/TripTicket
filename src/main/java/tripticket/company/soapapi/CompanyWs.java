package tripticket.company.soapapi;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import tripticket.company.bean.CompanyBeanI;
import tripticket.company.model.Company;

@WebService(serviceName = "companyws")
public class CompanyWs {

	@EJB
	private CompanyBeanI companyBean;
	
	@WebMethod
	public List<Company> list() {
		return companyBean.list();
	}
	
	@WebMethod
	public Company load(){
		List<Company> companies = companyBean.list(); 
		if(companies.isEmpty())
			return new Company();
		else
			return companies.get(0);
	}

}
