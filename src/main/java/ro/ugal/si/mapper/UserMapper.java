package ro.ugal.si.mapper;
import java.util.List;

import org.apache.ibatis.annotations.*;

import ro.ugal.si.model.User;
import ro.ugal.si.model.UserInfo;

public interface UserMapper {

	@Select("SELECT * FROM user")
	@Results(value = {
			@Result(property = "id_user", column = "id_user"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "role", column = "role")
	})   
	List<User> getAllUsers();

	@Select("SELECT * FROM user where role = #{role}")
	@Results(value = {
			@Result(property = "id_user", column = "id_user"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "role", column = "role")
	})   
	List<User> getUserByRole(String role);

	@Insert("INSERT INTO user(username,password,role) VALUES(#{username}, #{password}, #{role})")
	@Options(useGeneratedKeys=true, keyProperty="id_user")
	void insertUser(User user);

	@Insert("INSERT INTO userinfo(id_user,firstname,lastname,email) VALUES(#{idUser}, #{firstName}, #{lastName}, #{email})")
	@Options(useGeneratedKeys=true, keyProperty="id_userinfo")
	void insertUserInfo(UserInfo userInfo);


}
