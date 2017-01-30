/*
package trng.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

*/
/**
 * Created by Manohar on 1/7/2017.
 *//*

public class AccountOperationsHelper {

    AccountOperations accountOperations = new AccountOperationsImpl();

    public void viewAccount(HttpServletRequest request, HttpServletResponse response) {
        String accountNumber = request.getParameter("accountNumber");
        try {
            Account account = accountOperations.findAccount(Integer.parseInt(accountNumber));
            request.setAttribute("account", account);
            RequestDispatcher rd = request.getRequestDispatcher("/ViewAccount");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(HttpServletRequest request, HttpServletResponse response) {

    }
}
*/
