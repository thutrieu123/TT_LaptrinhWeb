package admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ManagerProduct
 */
@MultipartConfig()
@WebServlet("/manager_product")
public class ManagerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductDAO productDAO = new ProductDAO();

		List<Product> listProduct = productDAO.getAllProduct();
		request.setAttribute("listProduct", listProduct);
		String action = request.getParameter("action");
		String access = request.getParameter("access");
		
		if(access != null) {
			request.setAttribute("access", access);
		}

		if (action != null) {
//			if (action.equals("edit")) {
//				action = "";
//				String proId = request.getParameter("proId");
//				System.out.println(proId);
//				Product product = productDAO.getProductById(Integer.parseInt(proId));
//				List<Category> listCate = cateDAO.getAllCategory();
//				
//				request.setAttribute("product", product);
//				request.setAttribute("listCate", listCate);
//				request.getRequestDispatcher("/admin/productEdit.jsp").forward(request, response);
//				return;
//			} else 
			
			//Xoa san pham
			if (action.equals("trash")) {
				String proId = request.getParameter("proId");
				//Nho thay doi duong dan anh de xoa thanh cong
				String path = "F:\\TT_LTW\\TT_LaptrinhWeb\\Project_CK_LTWEB\\src\\main\\webapp\\"; // Cho nay la lay duong dan thu muc luu hinh anh

				Product product = productDAO.getProductById(Integer.parseInt(proId));
				path = path + product.getImage();
				File file = new File(path);
				System.out.println(file.getAbsolutePath());
				System.out.println(file.exists());
				System.out.println("Xoá "+ file.delete());

				productDAO.delete(product.getId());
				//message.put("success", "Xoá thành công");
				response.sendRedirect("/Project_CK_LTWEB/manager_product?access=yes");
			}

		} else
			request.getRequestDispatcher("/admin/manager_product.jsp").forward(request, response);
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
