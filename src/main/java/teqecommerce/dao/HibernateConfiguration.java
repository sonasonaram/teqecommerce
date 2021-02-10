package teqecommerce.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import teqecommerce.model.Cart;
import teqecommerce.model.Product;
import teqecommerce.model.User;

public class HibernateConfiguration {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		try {
			Configuration configuration  = new Configuration();
			 
			Properties hibernateProperties = new Properties();
			hibernateProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			hibernateProperties.put(Environment.URL, "jdbc:mysql://localhost/teq_e_commerce");
			hibernateProperties.put(Environment.USER, "root");
			hibernateProperties.put(Environment.PASS, "root");
			hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			hibernateProperties.put(Environment.SHOW_SQL, "true");
			hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
			 
			configuration.setProperties(hibernateProperties);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(Cart.class);
			 
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			 
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory = null;
		}
		
		 return sessionFactory;
	}
	
}
