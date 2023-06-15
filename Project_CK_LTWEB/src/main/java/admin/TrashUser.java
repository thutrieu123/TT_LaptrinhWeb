package admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class TrashUser
 */
@WebServlet("/TrashUser")
public class TrashUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrashUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		List<User> listUser = userDAO.getUserByRolId(2, 1);
		request.setAttribute("listUser", listUser);
		request.getSession().setAttribute("langeName", "vi_VN");
		request.getRequestDispatcher("/admin/trash_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		int eid = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));

		
		userDAO.changStatus(eid, status);
	}

}
