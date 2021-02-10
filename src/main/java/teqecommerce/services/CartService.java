package teqecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teqecommerce.dao.CartDAO;
import teqecommerce.model.Cart;

@Service
public class CartService {

	@Autowired
	CartDAO cartDao;
	
	@Autowired
	ProductService productService;
	
	public void addProductToCart(long productId, int userId) {
		Cart cartItem = new Cart();
		cartItem.setProductid(productId);
		cartItem.setUserid(userId);
		cartDao.addNewProductToCart(cartItem);
	}
	
	public void deleteProductFromCart(int cartId) {
		cartDao.deleteProductFromCart(cartId);
	}
	
	public List<String[]> getAllCartItemsForCurrentUser(int id) {
		List<Cart> cartItems = cartDao.getAllItemsFromCartForUser(id);
		List<String[]> productsInfo = new ArrayList<String[]>();
		for (Cart c: cartItems) {
			String[] productInfo = productService.getProductInfo(c.getProductid()+"");
			productInfo[2] = c.getId() + "";
			productsInfo.add(productInfo);
			
		}
		
		return productsInfo;
	}
}
