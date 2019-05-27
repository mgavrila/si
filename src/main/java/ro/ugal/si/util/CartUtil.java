package ro.ugal.si.util;

import ro.ugal.si.dao.CartDaoImpl;
import ro.ugal.si.model.Cart;

public class CartUtil {
	
	public boolean addToCart(int idUser, int idProduct) {
		boolean ok = false;
		CartDaoImpl dao = new CartDaoImpl();
		Cart cart = new Cart(idUser,idProduct);
		if(cart.getIdUser() != 0 && cart.getIdProduct() != 0) {
			ok = true;
			dao.insertCart(cart);
		}	
		return ok;
	}

}
