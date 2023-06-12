package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contanst.Status;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class ManagerUser
 */
@WebServlet("/manager_user")
public class ManagerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		UserDAO userDAO = new UserDAO();
		String action = request.getParameter("action");
		String update = request.getParameter("updateUser");
		String access = request.getParameter("access");
		
		if(access !=null) {
			request.setAttribute("access",access);
		}

		if (action != null) {
			if (action.equals("edit")) {
				String eUserId = request.getParameter("eUserId");

				User user = userDAO.getUser(Integer.parseInt(eUserId));

				request.setAttribute("eUser", user);
				request.getRequestDispatcher("/admin/userEdit.jsp").forward(request, response);
			}

//			} else if (action.equals("trash")) {
//				String eUserId = request.getParameter("eUserId");
////				userDAO.deleteUser(Integer.parseInt(eUserId));
//				
//				//Update trang thai cua User trong he thong thay doi trang thai status = 1 la khong hoat dong
//				int numberChang = userDAO.changStatus(Integer.parseInt(eUserId), Status.ENABLE);
//				System.out.println(numberChang);
//				response.sendRedirect("/Project_CK_LTWEB/manager_user?access=yes");
//			}
			else if(action.equals("detail")) {
				String eUserId = request.getParameter("eUserId");
				User user = userDAO.getUser(Integer.parseInt(eUserId));
				request.setAttribute("eUser", user);
				request.getRequestDispatcher("/admin/detailUser.jsp").forward(request, response);
			}
		} else if (update != null) {
			String userId = request.getParameter("userId");
			String userFullname = request.getParameter("userFullname");
			String userPhone = request.getParameter("userPhone");
			String userAddress = request.getParameter("userAddress");
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			String userRole = request.getParameter("userRole");
			
			
			System.out.println(userAddress);

			User userUpdate = new User(Integer.parseInt(userId), userFullname, userPhone, userAddress, userName,
					userPassword, Integer.parseInt(userRole));
			userDAO.updateUser(userUpdate);

			response.sendRedirect("/Project_CK_LTWEB/manager_user?access=yes");
		} else {
			//Lay ra danh sach User co rol la User va con hoat dong status = 0
			List<User> listUser = userDAO.getUserByRolId(2,Status.ACTIVE);
			request.setAttribute("listUser", listUser);
			request.getSession().setAttribute("langeName", "vi_VN");
			request.getRequestDispatcher("/admin/manager_user.jsp").forward(request, response);
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
