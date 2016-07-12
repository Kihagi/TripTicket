
/*package tripticket.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectDateAndRoute {
	@EJB
	//private RouteBeanI routeBean;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//this.list(response);
	}

	
	public void list(HttpServletResponse response) throws ServletException, IOException {
		
		String listInJson = "["
				+ "{"
				+ "\"loc_from\": \"NAIROBI\","
				+ "\"loc_to\": \"MOMBASA\""
				+ "},"
				+ "{"
				+ "\"loc_from\": \"NAIROBI\","
				+ "\"loc_to\": \"GARISSA\""
				+ "},"
				+ "{"
				+ "\"loc_from\": \"NAIROBI\","
				+ "\"loc_to\": \"KAMPALA\""
				+ "},"
				+ "{"
				+ "\"loc_from\": \"NAIROBI\","
				+ "\"loc_to\": \"BUSIA\""
				+ "}"
				+ "]";
		PrintWriter resp = response.getWriter();
		resp.println(listInJson);
	}
}*/
