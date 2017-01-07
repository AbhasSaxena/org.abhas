package trng.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userId");
		String password = request.getParameter("pwd");
		
		if (user.equals("gopi") && password.equals("tiger")) {
//			response.sendRedirect("/MyServletApp/home.html");
			response.sendRedirect("/MyServletApp/HomeServlet?pwd="+password);
//			RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
//			rd.forward(request, response);
		} else {
			response.setContentType("text/html");
			response.getWriter()
			.append("<html> <body>")
			.append("<span> Invalid User !! </span> <a href='/MyServletApp/Login.html'> Try Again! </a>")
			.append("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
