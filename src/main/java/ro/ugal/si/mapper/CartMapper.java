package ro.ugal.si.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import ro.ugal.si.model.Cart;

public interface CartMapper {
	
	@Insert("INSERT INTO cart(id_product,id_user) VALUES(#{idProduct}, #{idUser})")
	@Options(useGeneratedKeys=true, keyProperty="id_cart")
	void insertCart(Cart cart);

	@Delete("DELETE FROM cart WHERE id_cart =#{idCart}")
	void deleteCart(int id_cart);
}
