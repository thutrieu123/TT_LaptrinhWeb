package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import support.Endcoding;

@WebServlet("/userChangePass")
public class UserChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserChangePassController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		// request.setAttribute("check", true);
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String access = request.getParameter("access");

		String oldPass = request.getParameter("oldPass");
		// oldPass = Endcoding.encrypt(oldPass);
		String newPass = request.getParameter("newPass");
		String rePass = request.getParameter("rePass");

		System.out.println(oldPass);

		if (access != null) {
			request.setAttribute("access", access);
		}

		if (oldPass.equals(user.getPassword())) {
			if (newPass.equals(rePass)) {
				// newPass = Endcoding.encrypt(newPass);
				User userUpdate = new User(user.getId(), user.getFullName(), user.getNumberPhone(), user.getAddress(),
						user.getUserName(), newPass, user.getRolId(), user.getEmail());
				userDAO.changPassword(userUpdate.getUserName(), newPass);
				request.getSession().setAttribute("user", userUpdate);
				System.out.println(userUpdate);
				response.sendRedirect("/Project_CK_LTWEB/HomeController?access=Đổi mật khẩu thành công");
			} else {
				request.setAttribute("messageRe", "Nhập lại mật khẩu mới không chính xác");
				request.getRequestDispatcher("uChangePass.jsp").forward(request, response);
			}
		} else {
			request.getSession().setAttribute("langeName", "vi_VN");
			request.setAttribute("messageOld", "Mật khẩu không chính xác");
			request.getRequestDispatcher("uChangePass.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}