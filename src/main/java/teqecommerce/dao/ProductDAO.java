package teqecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import teqecommerce.model.Product;

@Component
public class ProductDAO {

	public void addNewProduct(Product product) {

		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(product);
			
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
	
	public List<Product> getAllProducts() {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			List<Object[]> rows = session.createSQLQuery("SELECT * FROM teq_e_commerce.Product;").list();
			List<Product> products = new ArrayList<Product>();
			for (Object[] row : rows) {
				Product product = new Product();
				product.setId(Long.parseLong(row[0].toString()));
				product.setName(row[1].toString());
				product.setPrice(row[2].toString());
				products.add(product);
			}
			
			transaction.commit();
			
			return products;
			
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
	
	public Product getProductInfo(long id) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			Product product = session.find(teqecommerce.model.Product.class, id);
			
			transaction.commit();
			return product;
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
}
