package ro.ugal.si.mapper;
import java.util.List;

import org.apache.ibatis.annotations.*;

import ro.ugal.si.model.User;
import ro.ugal.si.model.UserInfo;

public interface UserMapper {

	@Select("SELECT * FROM user")
	@Results(value = {
			@Result(property = "idUser", column = "id_user"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "role", column = "role")
	})   
	List<User> getAllUsers();
	
	@Select("SELECT * FROM user WHERE role != 'admin' ")
	@Results(value = {
			@Result(property = "idUser", column = "id_user"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "role", column = "role")
	})   
	List<User> getAllUserExceptAdmin();

	@Select("SELECT * FROM user where role = #{role}")
	@Results(value = {
			@Result(property = "idUser", column = "id_user"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "role", column = "role")
	})   
	List<User> getUserByRole(String role);
	
	@Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
	@Results(value = {
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password")
	})   
	User getUserLogin(@Param("username")String username,@Param("password") String password);
	
	@Select("SELECT role FROM user WHERE username = #{username}")
	@Results(value = {
			@Result(property = "role", column = "role")
	})   
	String getUserRole(@Param("username")String username);
	
	@Select("SELECT id_user FROM user WHERE username = #{username}")
	@Results(value = {
			@Result(property = "idUser", column = "id_user")
	})   
	int getUserIdByUsername(@Param("username")String username);

	@Insert("INSERT INTO user(username,password,role) VALUES(#{username}, #{password}, #{role})")
	@Options(useGeneratedKeys=true, keyProperty="idUser",keyColumn = "id_user")
	void insertUser(User user);

	@Insert("INSERT INTO userinfo(id_user,firstname,lastname,email) VALUES(#{idUser}, #{firstName}, #{lastName}, #{email})")
	@Options(useGeneratedKeys=true, keyProperty="idUserInfo",keyColumn = "id_userInfo")
	void insertUserInfo(UserInfo userInfo);

	@Delete("DELETE FROM user WHERE username = #{username}")
	void deleteUsername(String username);
	
	@Delete("DELETE FROM userinfo WHERE id_user = #{idUser}")
	void deleteUserInfo(int idUser);
}
