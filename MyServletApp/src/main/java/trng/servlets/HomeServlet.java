package trng.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.servlets.beans.User;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		response.getWriter().append("<html><body>");
		
		if (user != null && user.getRoles().contains("ROLE_ADMIN")) {
			response.getWriter().append("<a href='/MyServletApp/AddAccount.jsp'>Add Account</a> <br>");
		}


		response.getWriter()
				.append("<a href='/MyServletApp/ViewAccount.jsp'>View Account</a> <br>")
				.append(generateCountryDropdown(request))
				.append("</body></html>");
	}

	private String generateCountryDropdown(HttpServletRequest request) {
		List<String> counties = (List<String>) request.getServletContext().getAttribute("countries");
		System.out.println("Application from session : " + request.getSession().getServletContext());
		System.out.println("Application from session : " + request.getServletContext());
		StringBuilder countryDropdownBulider = new StringBuilder("<select>");
		for (String country:counties) {
			countryDropdownBulider.append("<option> ").append(country).append("</option>");
		}
		countryDropdownBulider.append("</select>");
		return countryDropdownBulider.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
