package trng.servlets;

import trng.servlets.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HomeServlet
 */
public class AccountOperationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountOperationsHelper helper = new AccountOperationsHelper();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountOperationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("VIEW_ACCOUNT")) {
                helper.viewAccount(request, response);

            } else if (action.equals("ADD_ACCOUNT")) {
                helper.addAccount(request, response);

            }
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
