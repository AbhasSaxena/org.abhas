package trng.servlets.beans;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	private String userId;
	private String password;
	private List<String> roles;
	@Autowired
	private SessionFactory sessionFactory;


	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
//	public String getUserId(String id) {
//		return userId;
//	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	public User getUserById(Long userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM User");
		List<User> users = (List<User>) query.list();
		session.close();
		return users;
	}
	public User update(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		return user;
	}


}
