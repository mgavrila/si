package main;

import ro.ugal.si.dao.CartDaoImpl;
import ro.ugal.si.dao.UserDaoImpl;
import ro.ugal.si.model.User;
import ro.ugal.si.util.UserUtil;

public class MainMethod {

	public static void main(String[] args) {

	//	UserDaoImpl dao = new UserDaoImpl();
	//	System.out.println(dao.getAllUsers());
		
		UserUtil util = new UserUtil();
	//	System.out.println(util.userLogin("admin", "admin"));
	//	System.out.println(dao.getUserIdByUsername("admin"));
		
		CartDaoImpl dao = new CartDaoImpl();
		System.out.println(dao.getUserProducts(10));
	}

}
