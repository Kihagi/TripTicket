import javax.ws.rs.Path;

import tripticket.company.bean.CompanyBeanI;
import tripticket.company.model.Company;



@Path("/company")
public class CompanyApi {
	
	private CompanyBeanI companyBean;
	
	@Path("/add")
	public String add(Company company){
		
		companyBean.add(company);
		
		return "{success: true}";
	}

}
