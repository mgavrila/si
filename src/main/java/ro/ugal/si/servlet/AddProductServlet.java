package ro.ugal.si.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import ro.ugal.si.util.ManagementUtil;
import ro.ugal.si.util.SIVars;

/**
 * Servlet implementation class ManagementServlet
 */
@WebServlet("/addProduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("addName");
		String productPrice = request.getParameter("addPrice");
		String author = request.getParameter("addAuthor");
		Part  filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		String productDescription = request.getParameter("addDescription");
		String redirectURL = null;
		
		ManagementUtil util = new ManagementUtil();
		
		if(util.insertProduct(productName, Double.parseDouble(productPrice), author, fileName, productDescription)) {
			logger.info("Succesfully inserted product");
			InputStream fileContent = filePart.getInputStream();
			String filepath = SIVars.IMG_DIR+File.separator+fileName;
			util.saveToFile(fileContent, filepath);
			redirectURL = "view/admin/management.jsp";
			response.sendRedirect(redirectURL);
		}else {
			logger.severe("Error adding product");
		}		
	}

}
 