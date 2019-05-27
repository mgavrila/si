package ro.ugal.si.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import ro.ugal.si.dao.ProductDaoImpl;
import ro.ugal.si.model.Product;

public class ManagementUtil {

	private ProductDaoImpl dao = new ProductDaoImpl();
	private Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());


	public boolean insertProduct(String productName, Double productPrice, String author, String file, String productDescription) {
		boolean ok = false;

		Product product = new Product();

		if(checkFields(productName, productPrice, author, file, productDescription)) {
			ok = true;
			product.setName(productName);
			product.setPrice(productPrice);
			product.setPath(file);
			product.setDescription(productDescription);
			product.setAuthor(author);

			dao.insertProduct(product);
		}
		return ok;
	}

	public boolean deleteProduct(String productName) {
		boolean ok = false;
		if(productName != null) {
			ok = true;
			dao.deleteProduct(productName);			
		}else {
			logger.info("product can't be null");
		}
		return ok;
	}


	public boolean checkFields(String productName, Double productPrice, String author, String file, String productDescription) {
		boolean ok = false;
		if(productName != null && productPrice != null && author != null && file != null && productDescription != null) {
			ok = true;
		}	

		return ok;
	}
	

	public void saveToFile(InputStream inStream, String target){
		int read = 0;
		byte[] bytes = new byte[1024];
		try {
			OutputStream out = new FileOutputStream(new File(target));
			while ((read = inStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.close();
			out.flush();
		} catch (IOException e) {
			logger.severe("IOException in saveToFile");
		}
	}

}
