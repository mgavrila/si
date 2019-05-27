package ro.ugal.si.util;

import ro.ugal.si.dao.UserDaoImpl;
import ro.ugal.si.model.User;
import ro.ugal.si.model.UserInfo;

public class UserUtil {
	private UserDaoImpl dao = new UserDaoImpl();
	
	public String userLogin(String username, String password) {
		String role = null;			
		User user = new User(username,password);
		User userLogin = dao.getUserLogin(username, password);
		if(userLogin.getUsername().equals(user.getUsername()) 
				&& userLogin.getPassword().equals(user.getPassword())) {
			role = dao.getUserRole(username);
		}else {
			role = "no role found because user doesn't exist";
		}
		return role;
	}
	
	public boolean insertUser(String firstName, String lastName, String email, String username, String password) {
		boolean ok = false;
		User user = new User();
		user.setUsername(username);
		user.setRole("user");
		user.setPassword(password);
		
		UserInfo userInfo  = new UserInfo();
		userInfo.setFirstName(firstName);
		userInfo.setLastName(lastName);
		userInfo.setEmail(email);
		
		if(checkFields(firstName,lastName,email,username,password)) {
			ok = true;
			dao.insertUser(user);
			userInfo.setIdUser(user.getIdUser());
			dao.insertUserInfo(userInfo);
		}
		return ok;			
	}
	
	public boolean deleteUser(String username) {
		boolean ok = false;
		if(username != null) {
			ok = true;
			dao.deleteUserInfo(dao.getUserIdByUsername(username));
			dao.deleteUsername(username);
		}	
		return ok;
	}
		
	public boolean checkFields(String firstName, String lastName, String email, String username, String password) {
		boolean ok = false;
		if(firstName != null && lastName != null && email != null && username != null && password != null) {
			ok = true;
		}		
		return ok;		
	}

}
