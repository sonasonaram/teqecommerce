package teqecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import teqecommerce.model.Cart;
import teqecommerce.model.Product;

@Component
public class CartDAO {

	public void addNewProductToCart(Cart cartItem) {

		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(cartItem);
			
			transaction.commit();
		} catch (Exception e) {
			if (null != transaction)
				transaction.rollback();
		} finally {
			session.close();
			session = null;
			transaction = null;
		}
	}
	
	public List<Cart> getAllItemsFromCartForUser(int userId) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			List<Object[]> rows = session.createSQLQuery("SELECT * FROM teq_e_commerce.Cart WHERE userid='" + userId + "';").list();
			List<Cart> cartItems = new ArrayList<Cart>();
			for (Object[] row : rows) {
				Cart cartItem = new Cart();
				cartItem.setId(Integer.parseInt(row[0].toString()));
				cartItem.setProductid(Long.parseLong(row[1].toString()));
				cartItem.setUserid(Integer.parseInt(row[2].toString()));
				cartItems.add(cartItem);
			}
			
			transaction.commit();
			
			return cartItems;
			
		} catch (Exception e) {
			if (null != transaction)
				transaction.rollback();
		} finally {
			session.close();
			session = null;
			transaction = null;
		}
		
		return null;
	}
	
	public void deleteProductFromCart(int cartId) {

		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Cart cartItem = session.find(teqecommerce.model.Cart.class, cartId);
			session.delete(cartItem);
			
			transaction.commit();
		} catch (Exception e) {
			if (null != transaction)
				transaction.rollback();
		} finally {
			session.close();
			session = null;
			transaction = null;
		}
	}
}
