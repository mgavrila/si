package ro.ugal.si.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ro.ugal.si.mapper.Mapper;
import ro.ugal.si.mapper.ProductMapper;
import ro.ugal.si.model.Product;

public class ProductDaoImpl implements ProductMapper{
	
	private Mapper mapper;
	private SqlSession session;

	public ProductDaoImpl() {
		mapper = new Mapper();
		session = mapper.getSqlSession();
		}

	public void insertProduct(Product product) {
		mapper.getProductMapper().insertProduct(product);
		session.commit();	
	}

	public List<Product> getAllProducts() {
		return mapper.getProductMapper().getAllProducts();
	}

	public void deleteProduct(String productName) {
		mapper.getProductMapper().deleteProduct(productName);
		session.commit();
	}

}
