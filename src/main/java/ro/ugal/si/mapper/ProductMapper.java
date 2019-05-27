package ro.ugal.si.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ro.ugal.si.model.Product;

public interface ProductMapper {
	

	@Select("SELECT * FROM product")
	@Results(value = {
			@Result(property = "idProduct", column = "id_product"),
			@Result(property = "name", column = "name"),
			@Result(property = "price", column = "price"),
			@Result(property = "path", column = "path"),
			@Result(property = "description", column = "description"),
			@Result(property = "author", column = "author")
	})   
	List<Product> getAllProducts();
	
	@Insert("INSERT INTO product(name,price,path,description,author) VALUES(#{name}, #{price}, #{path}, #{description}, #{author})")
	@Options(useGeneratedKeys=true, keyProperty="idProduct",keyColumn = "id_product")
	void insertProduct(Product product);

	@Delete("DELETE FROM product WHERE name = #{name}")
	void deleteProduct(String productName);
	
}	
