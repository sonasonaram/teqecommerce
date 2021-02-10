package teqecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import teqecommerce.services.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginScreen() {
		return "loginscreen";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin(@RequestParam (name="email") String email, @RequestParam (name="password") String pass, HttpServletRequest req, HttpServletResponse resp) {
		int[] statusAndId = userService.findUserInDB(email, pass);
		if (statusAndId[0] == 1) {
			req.getSession().setAttribute("logged_in_id", statusAndId[1]);
			return "inventory";
		}
		else if (statusAndId[0] == 0) {
			req.getSession().setAttribute("logged_in_id", statusAndId[1]);
			return "products";
		}
		else
			return "loginerror";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String createANewUserAccount(
											@RequestParam (name="email") String email,
											@RequestParam (name="name") String name,
											@RequestParam (name="pass") String pass,
											@RequestParam (name="address") String address,
											@RequestParam (name="isAdmin") String isAdmin
										) {
		userService.createUser(email, name, pass, address, isAdmin);
		return "loginscreen";
	}
}
