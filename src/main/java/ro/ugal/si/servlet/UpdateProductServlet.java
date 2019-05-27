package ro.ugal.si.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		String productName = request.getParameter("updateName");
		String productPrice = request.getParameter("updatePrice");
		String author = request.getParameter("updateAuthor");
		String productDescription = request.getParameter("updateDescription");
		String productId = request.getParameter("hidden");
		
		System.out.println("productName: " + productName);
		System.out.println("productPrice: " + productPrice);
		System.out.println("author: " + author);
		System.out.println("productDescription: " + productDescription);
		System.out.println("productId: " + productId);
		
	}

}
