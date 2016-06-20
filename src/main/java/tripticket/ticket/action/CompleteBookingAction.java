package tripticket.ticket.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/completebooking")
public class CompleteBookingAction extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter resp = response.getWriter();

		String tripId, name, idNumber, phone;
		tripId = request.getParameter("tripId");
		name = request.getParameter("name").toUpperCase();
		idNumber = request.getParameter("idNumber").toUpperCase();
		phone = request.getParameter("phone");

		resp.println("<div class=\"text-center\">");
		resp.println("<h4>Thank you for booking!</h4>");
		resp.println("</div>");

		resp.println("<hr>");
		resp.println("<div class=\"row\">");
		resp.println("<div class=\"col-md-12\">");
		resp.println("Trip Identification: "+tripId+"<br><br>");
		resp.println("Full Name: "+name+"<br><br>");
		resp.println("Cell Phone: "+phone+"<br><br>");
		resp.println("Identification Number: "+idNumber+"<br><br>");
		resp.println("</div>");
		resp.println("</div>");

	}
}
