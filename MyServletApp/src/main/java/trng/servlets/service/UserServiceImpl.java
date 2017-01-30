/*
package trng.servlets.service;

import trng.servlets.beans.User;

import java.sql.SQLException;


public class UserServiceImpl implements UserService {
	
	
	DBEmployeeOperations userOperations = new DBEmployeeOperations();
	
	
	public boolean validateUser(int userId, String password) {
		try {
			 User user = userOperations.findUser(userId);
			
			if(user != null && user.getPassword().equals(password)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
*/
