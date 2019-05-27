package ro.ugal.si.servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ro.ugal.si.dao.UserDaoImpl;
import ro.ugal.si.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserUtil userUtil = new UserUtil();
		String redirectURL =  null;

		if(userUtil.userLogin(username, password).equals("admin")) {				
			redirectURL = "view/admin/management.jsp";
			response.sendRedirect(redirectURL);
		}else {
			if(userUtil.userLogin(username, password).equals("user")){	
				UserDaoImpl dao = new UserDaoImpl();
				HttpSession session = request.getSession();
			      session.setAttribute("userId",dao.getUserIdByUsername(username) );
				redirectURL = "view/shop.jsp";
				response.sendRedirect(redirectURL);					
			}
		}
	}
}
