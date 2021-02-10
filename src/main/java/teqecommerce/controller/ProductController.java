package teqecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import teqecommerce.model.User;
import teqecommerce.services.CartService;
import teqecommerce.services.ProductService;
import teqecommerce.services.UserService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public ModelAndView addProduct(@RequestParam (name="name") String name, @RequestParam (name="price") String price) {
		
		productService.createProduct(name, price);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("STATUS", "Product Successfully Added. ");
		mv.setViewName("inventory");
		
		return mv;
	}
	
	@RequestMapping(value="/allproduct", method=RequestMethod.GET)
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("PRODUCTS", productService.getAllProducts());
		mv.setViewName("products");
		return mv;
	}
	
	@RequestMapping(value="/purchase", method=RequestMethod.POST)
	public ModelAndView purchaseProduct(@RequestParam (name="productid") String id, HttpServletRequest req, HttpServletResponse resp) {
		
		ModelAndView mv = new ModelAndView();
		try {
		
			User user = userService.findUserInDB(Integer.parseInt(req.getSession().getAttribute("logged_in_id").toString()));
			
			mv.addObject("USER", user);
			mv.addObject("PRODUCT_INFO", productService.getProductInfo(id));
			mv.setViewName("payment2");
		}
		catch (Exception e) {
			mv.setViewName("loginscreen");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/purchaseall", method=RequestMethod.POST)
	public ModelAndView purchaseAllProductsInCart(HttpServletRequest req, HttpServletResponse resp) {
		
		ModelAndView mv = new ModelAndView();
		try {
		
			User user = userService.findUserInDB(Integer.parseInt(req.getSession().getAttribute("logged_in_id").toString()));
			List<String[]> cartItems = cartService.getAllCartItemsForCurrentUser(user.getId());
			
			for(int i = 0; i < cartItems.size(); i++) {
				cartService.deleteProductFromCart(Integer.parseInt(cartItems.get(i)[2]));
			}
			
			
			mv.addObject("USER", user);
			mv.addObject("PRODUCT_INFO", cartItems);
			mv.setViewName("payment");
		}
		catch (Exception e) {
			mv.setViewName("loginscreen");
		}
		return mv;
	}
	
}
