package teqecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teqecommerce.dao.ProductDAO;
import teqecommerce.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDao;
	
	public void createProduct(String name, String price) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		
		productDao.addNewProduct(product);
	}
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public String[] getProductInfo(String id) {
		Product product = productDao.getProductInfo(Long.parseLong(id));
		String[] info = {product.getName(), product.getPrice(), product.getId()+""};
		return info;
	}
}
