package trng.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VisitorsCountServlet
 */
public class VisitorsCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorsCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/html");
		  
		    // Get the current session object, create one if necessary
		    HttpSession session = request.getSession(true);

		    // Increment the hit count for this page. The value is saved
		    // in this client's session under the name "tracker.count".
		    Integer count = (Integer)session.getAttribute("tracker.count");
		    if (count == null)
		      count = new Integer(1);
		    else
		    {
		      count = new Integer(count.intValue() + 1);
		    session.setAttribute("tracker.count", count);

		    response.getWriter().append("you are "+count+"th user ").append(request.getParameter("name"));
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
