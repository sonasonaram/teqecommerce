package teqecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teqecommerce.dao.UserDAO;
import teqecommerce.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDao;
	
	public void createUser(String email, String name, String pass, String address, String isAdmin) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setPassword(pass);
		if (isAdmin.equals("yes"))
			user.setAdmin(true);
		else
			user.setAdmin(false);
		
		userDao.addNewUser(user);
	}
	
	public int[] findUserInDB(String email, String pass) {
		User user = userDao.findUser(email, pass);
		if (user != null) {
			if (user.isAdmin())
				return new int[] {1, user.getId()};
			else
				return new int[] {0, user.getId()};
		}
		return new int[] {-1, -1};
	}
	
	public User findUserInDB(int id) {
		return userDao.findUser(id);
	}
}
