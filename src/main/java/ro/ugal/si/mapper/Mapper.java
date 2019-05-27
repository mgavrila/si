package ro.ugal.si.mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mapper {

	private SqlSession sqlSession;

	private BufferedReader bufferedReader;

	private SqlSessionFactory sqlSessionFactory;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	private UserMapper userMapper;
	
	private ProductMapper productMapper;
	
	private CartMapper cartMapper;


	public Mapper() {
		try {
			bufferedReader = new BufferedReader(Resources.getResourceAsReader("config.xml"));
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(bufferedReader);
		sqlSession = sqlSessionFactory.openSession();
		sqlSession.getConfiguration().addMapper(UserMapper.class);
		sqlSession.getConfiguration().addMapper(ProductMapper.class);
		sqlSession.getConfiguration().addMapper(CartMapper.class);

		this.userMapper = sqlSession.getMapper(UserMapper.class);
		this.productMapper = sqlSession.getMapper(ProductMapper.class);
		this.cartMapper = sqlSession.getMapper(CartMapper.class);
	}


	public SqlSession getSqlSession() {
		return sqlSession;
	}


	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}


	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	public UserMapper getUserMapper() {
		return userMapper;
	}


	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	public ProductMapper getProductMapper() {
		return productMapper;
	}


	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}


	public CartMapper getCartMapper() {
		return cartMapper;
	}


	public void setCartMapper(CartMapper cartMapper) {
		this.cartMapper = cartMapper;
	}
	
	
}
