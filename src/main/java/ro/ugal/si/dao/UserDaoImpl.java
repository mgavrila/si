package ro.ugal.si.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import ro.ugal.si.mapper.Mapper;
import ro.ugal.si.mapper.UserMapper;
import ro.ugal.si.model.User;
import ro.ugal.si.model.UserInfo;

public class UserDaoImpl implements UserMapper{
	
	private Mapper mapper;
	private SqlSession session;

	public UserDaoImpl() {
		mapper = new Mapper();
		session = mapper.getSqlSession();
		}

	public List<User> getAllUsers() {
		return mapper.getUserMapper().getAllUsers();
	}

	public List<User> getUserByRole(String role) {
		return mapper.getUserMapper().getUserByRole(role);
	}

	public void insertUser(User user) {
		mapper.getUserMapper().insertUser(user);
		session.commit();
	}

	public void insertUserInfo(UserInfo userInfo) {
		mapper.getUserMapper().insertUserInfo(userInfo);
		session.commit();
		
	}

	public User getUserLogin(String username, String password) {
		return mapper.getUserMapper().getUserLogin(username, password);
	}

	public String getUserRole(String username) {
		return mapper.getUserMapper().getUserRole(username);
	}

	public int getUserIdByUsername(String username) {
		return mapper.getUserMapper().getUserIdByUsername(username);
	}

	public void deleteUsername(String username) {
		mapper.getUserMapper().deleteUsername(username);
		session.commit();		
	}

	public void deleteUserInfo(int idUser) {
		mapper.getUserMapper().deleteUserInfo(idUser);
		session.commit();
	}

	public List<User> getAllUserExceptAdmin() {
		return mapper.getUserMapper().getAllUserExceptAdmin();
	}

}
