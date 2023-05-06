package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;
import support.Endcoding;

/**
 * Servlet implementation class ChangeInforAdmin
 */
@WebServlet("/change_admin")
public class ChangeInforAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInforAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPass = request.getParameter("oldPass");
		
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println("Pass nè");
		System.out.println("Pass" + oldPass);
		
		UserDAO userDAO = new UserDAO();
		User user = (User)request.getSession().getAttribute("user");
		
		if(oldPass != null && !oldPass.equals("")) {
			String newPass = request.getParameter("newPass");
			System.out.println(newPass);
			newPass = Endcoding.encrypt(newPass);
			user.setFullName(fullName);
			user.setEmail(email);
			user.setNumberPhone(phone);
			user.setPassword(newPass);
			userDAO.updateUser(user);
		}else {
			user.setFullName(fullName);
			user.setEmail(email);
			user.setNumberPhone(phone);
			userDAO.updateUser(user);
		}
		response.sendRedirect("/Project_CK_LTWEB/admin/adminProfile.jsp");		
		
		
	}

}
