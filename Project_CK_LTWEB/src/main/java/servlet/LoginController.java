package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import contanst.MyAddress;
import contanst.Role;
import contanst.Status;
import dao.AddressDAO;
import dao.UserDAO;
import model.Address;
import model.Location;
import model.User;
import support.Endcoding;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession(true);
		Map<String, String> message = new HashMap<>();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String logOut = request.getParameter("logOut");
		String error = request.getParameter("error");
		String access = request.getParameter("access");
		
		
		//Lay ra User co status = 0 la con quyen duoc vao he thong
		User user = userDAO.getUser(userName,Status.ACTIVE);
		User userTrash = userDAO.getUser(userName, Status.ENABLE);
		System.out.println(userName);
		request.setAttribute("message", message);
		

		if (logOut != null) {
//			request.removeAttribute("message");
//			session.removeAttribute("user");
			session.invalidate();
			response.sendRedirect("HomeController");
		} else if (error != null) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		} else if (access != null) {
			request.setAttribute("access","Đổi mật khẩu thành công!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		} else if (user != null) {
			password = Endcoding.encrypt(password);
			if (user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				CartController cart = new CartController();
				cart.reCart(request);
				session.setMaxInactiveInterval(5000);
				if (user.getRolId() == Role.ADMIN)
					// request.getRequestDispatcher("/admin/adminHeader.jsp").forward(request,
					// response);
					response.sendRedirect("/Project_CK_LTWEB/admin");
				else
					response.sendRedirect("HomeController");
			} else {
				message.put("passwordError", "Sai Mật Khẩu");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			if(userTrash != null) {
				message.put("userError", "Tài đã bị khoá ");
			}else {
				message.put("userError", "Tài khoản không tồn tại");
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
