package teqecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import teqecommerce.model.User;

@Component
public class UserDAO {
	
	public void addNewUser(User user) {

		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(user);
			
			transaction.commit();
		} catch (Exception e) {
			if (null != transaction)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session = null;
			transaction = null;
		}
	}
	
	public User findUser(String email, String pass) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			List<Object[]> rows = session.createSQLQuery("SELECT * FROM teq_e_commerce.user WHERE email='" + email + "' AND password='" + pass + "';").list();
			if (rows != null && rows.size() >= 1) {
				User user = new User();
				user.setId(Integer.parseInt(rows.get(0)[0].toString()));
				user.setAddress(rows.get(0)[1].toString());
				user.setEmail(rows.get(0)[2].toString());
				user.setAdmin(Boolean.parseBoolean(rows.get(0)[3].toString()));
				user.setName(rows.get(0)[4].toString());
				user.setPassword(rows.get(0)[5].toString());
				return user;
			}
			
		} catch (Exception e) {
			if (null != transaction)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session = null;
			transaction = null;
		}
		return null;
	}
	
	
	public User findUser(int id) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			User user = session.find(teqecommerce.model.User.class, id);
			
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			if (null != transaction)
				transaction.rollback();
		} finally {
			session.close();
			session = null;
			transaction = null;
		}
		return null;
	}
}
