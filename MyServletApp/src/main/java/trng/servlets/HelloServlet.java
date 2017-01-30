package trng.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StringBuffer sb;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		sb = new StringBuffer();
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sb.append(request.getRemoteHost());
		displayCookies(request, response);
		writeHitCount(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void writeHitCount(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie:cookies) {
			if (cookie.getName().equals("hitCount")) {
				cookie.setValue(String.valueOf(Integer.parseInt(cookie.getValue()) + 1));
				response.addCookie(cookie);
				return;
			}
		}
		Cookie hitCountCookie = new Cookie("hitCount", "1");
		response.addCookie(hitCountCookie);
	}

	private void displayCookies(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie:cookies) {
			if (cookie.getName().equals("hitCount")) {
				response.getWriter().write("You visited for " + cookie.getValue() + " times");
				return;
			}
		}

		response.getWriter().write("This is your first visit to this page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
