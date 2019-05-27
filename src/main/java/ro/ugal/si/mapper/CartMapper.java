package ro.ugal.si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;

import ro.ugal.si.model.Cart;
import ro.ugal.si.model.Product;
import ro.ugal.si.model.User;

public interface CartMapper {
	
	@Select("SELECT * FROM cart WHERE id_user = #{idUser}")
	@Results({
		@Result(property = "idCart", column = "id_cart"),
		@Result(property="customProduct", column="id_product", javaType=Product.class, one=@One(select="getProduct")),
		@Result(property="customUser", column="id_user", javaType=User.class, one=@One(select="getUser"))
	})
	List<Cart> getUserProducts(int idUser);	
	
	@Select("SELECT * FROM product WHERE id_product = #{idProduct}")
	@Results(value = {
			@Result(property = "idProduct", column = "id_product"),
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"),
			@Result(property = "path", column = "path"),
			@Result(property = "description", column = "description"),
			@Result(property = "author", column = "author")
	})   
	Product getProduct();
	
	@Select("SELECT * FROM user WHERE id_user = #{idUser}")
	@Results(value = {
			@Result(property = "idUser", column = "id_user"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "role", column = "role")
	})   
	User getUser();
	
	@Insert("INSERT INTO cart(id_product,id_user) VALUES(#{idProduct}, #{idUser})")
	@Options(useGeneratedKeys=true, keyProperty="idCart",keyColumn = "id_cart")
	void insertCart(Cart cart);

	@Delete("DELETE FROM cart WHERE id_cart =#{idCart}")
	void deleteCart(int id_cart);
}
