package ro.ugal.si.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ro.ugal.si.mapper.CartMapper;
import ro.ugal.si.mapper.Mapper;
import ro.ugal.si.model.Cart;
import ro.ugal.si.model.Product;
import ro.ugal.si.model.User;

public class CartDaoImpl implements CartMapper{
	
	private Mapper mapper;
	private SqlSession session;

	public CartDaoImpl() {
		mapper = new Mapper();
		session = mapper.getSqlSession();
		}
	
	public void insertCart(Cart cart) {
		mapper.getCartMapper().insertCart(cart);
		session.commit();
	}

	public void deleteCart(int id_cart) {
		mapper.getCartMapper().deleteCart(id_cart);
		session.commit();		
	}

	public List<Cart> getUserProducts(int idUser) {
		return mapper.getCartMapper().getUserProducts(idUser);
	}

	public Product getProduct() {
		return mapper.getCartMapper().getProduct();
	}

	public User getUser() {
		return mapper.getCartMapper().getUser();
	}
}
