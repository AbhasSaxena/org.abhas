package trng.servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Filter implementation class UserValidationFilter
 */
public class UserValidationFilter implements Filter {

	Map<String, Integer> hitCount = new HashMap<String, Integer>();

	/**
	 * Default constructor.
	 */
	public UserValidationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter called");
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		String contextPath = req.getContextPath();

		synchronized (this) {
			if (req.getServletPath() != null) {
				if (hitCount.get(req.getServletPath()) != null) {
					hitCount.put(req.getServletPath(), hitCount.get(req.getServletPath()) + 1);
				} else {
					hitCount.put(req.getServletPath(), 1);
				}
			}

			displaySummary();
		}

		if (isSecuredPath(req) && session == null) {
			res.sendRedirect(contextPath + "/Login.html");
			// response.getOutputStream().write("Not Authorized".getBytes());
		} else if (isSecuredPath(req) && session.getAttribute("user") == null) {
			res.sendRedirect(contextPath + "/Login.html");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	private boolean isSecuredPath(HttpServletRequest req) {
		String contextPath = req.getContextPath();
		String requestURI = req.getRequestURI();
		System.out.println("requestURI" + requestURI);
		System.out.println("contextPath" + contextPath);
		System.out.println("RequestURL" + req.getRequestURL());
		System.out.println("PathInfo" + req.getPathInfo());
		
		return isSecuredPath(requestURI, contextPath);
	}

	private boolean isSecuredPath(String requestURI, String contextPath) {
		if(requestURI.contains("Login.html") || requestURI.contains("login.jsp") || requestURI.contains("loginError.html") ||
				requestURI.contains("index.html") || requestURI.contains("login.do") ||
				requestURI.contains("welcome.jsp") ||  isDefaultPath(contextPath, requestURI)) {
			return false;
		}
		
		return true;
	}

	

	private boolean isDefaultPath(String contextPath, String requestURI) {
		return requestURI.substring(contextPath.length()).length() == 1;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private void displaySummary() {
		for (Map.Entry<String, Integer> entry : hitCount.entrySet()) {
			System.out.printf("%10s  %10s", entry.getKey(), entry.getValue());
		}

	}

	public static void main(String[] args) {
		String contextPath = "/MyJSPWebApp", requestURI = "/MyJSPWebApp/";

		System.out.println(requestURI.substring(contextPath.length()));
	}
}
