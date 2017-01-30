package trng.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trng.servlets.beans.User;
import trng.servlets.service.UserService;
import trng.servlets.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService = new UserServiceImpl();
	String url = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig servletConfig) throws ServletException {

		super.init();
		url = servletConfig.getInitParameter("authentionUrl");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String headData = getHeaderInfo(request);
		User userBean = validateUser(request);
		if (userBean != null) {
			
			HttpSession httpSession = request.getSession();
			System.out.println("Session created");
			httpSession.setAttribute("user", userBean);
//			response.sendRedirect("/MyServletApp/home.html");
//			response.sendRedirect("/MyServletApp/HomeServlet?pwd="+password);
			RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
			rd.forward(request, response);
		} else {
			response.setContentType("text/html");
			response.getWriter()
			.append("<html> <body>")
			.append("<span> Invalid User !! </span> <a href='/MyServletApp/Login.html'> Try Again! </a>"
					+ "<h4>Header Data </h4>")
			.append(headData)
			.append("</body></html>");
		}
	}

	private User validateUser(HttpServletRequest request) {
		String user = request.getParameter("userId");
		String password = request.getParameter("pwd");
		boolean validUser = userService.validateUser(Integer.parseInt(user),  password);
		if (validUser) {
			User userBean = new User(user, password);
			userBean.setRoles(Arrays.asList("ROLE_ADMIN", "ROLE_CLERK"));
			return userBean;
		} else {
			return null;
		}
	}

	private String getHeaderInfo(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		String contentType = request.getHeader("content-type");
		System.out.println("contentType : " + contentType);
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			sb.append(headerName + " :: " + request.getHeader(headerName));
		}
		return sb.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
