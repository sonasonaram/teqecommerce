package teqecommerce.controller;

import java.io.IOException;

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
import teqecommerce.services.UserService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addtocart", method=RequestMethod.POST)
	public void addProductToCart(@RequestParam (name="productid") String pid, HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			cartService.addProductToCart(Long.parseLong(pid), Integer.parseInt(req.getSession().getAttribute("logged_in_id").toString()));
		}
		catch (Exception e) {
		}
		
		try {
			resp.sendRedirect("allproduct");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public ModelAndView getAllCartItemsForCurrentUser(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		try {
		
			User user = userService.findUserInDB(Integer.parseInt(req.getSession().getAttribute("logged_in_id").toString()));
			
			mv.addObject("USER", user);
			mv.addObject("PRODUCT_INFO", cartService.getAllCartItemsForCurrentUser(user.getId()));
			mv.setViewName("cart");
		}
		catch (Exception e) {
			mv.setViewName("loginscreen");
		}
		return mv;
	}
	
	@RequestMapping(value="/deletefromcart", method=RequestMethod.POST)
	public void deleteCurrentItemFromCart(@RequestParam (name="cartid") String cid, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		try {
			cartService.deleteProductFromCart(Integer.parseInt(cid));
		}
		catch (Exception e) {
		}
		try {
			resp.sendRedirect("cart");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
