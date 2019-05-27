package ro.ugal.si.servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ro.ugal.si.util.CartUtil;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());

	public CartServlet() {
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
		String valueSelected = request.getParameter("hidden");
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		String redirectURL = null;

		CartUtil util = new CartUtil();
		if(util.addToCart(Integer.parseInt(valueSelected),userId )){
			redirectURL = "view/checkout.jsp";
			response.sendRedirect(redirectURL);
		}else {
			logger.severe("error adding product into cart list");
		}
	}

}
