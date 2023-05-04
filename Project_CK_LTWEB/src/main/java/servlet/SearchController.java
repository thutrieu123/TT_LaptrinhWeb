package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		ProductDAO productDAO = new ProductDAO();
		
		String txtSearch = request.getParameter("txt");
		String result = "";
		
		List<Product> listProductNew = productDAO.getNewProduct(0);
		List<Product> list = productDAO.getProductByName(txtSearch, 0);
		if (list.size() > 0) {
			result = "Kết quả tìm kiếm cho sản phẩm '" + txtSearch + "'";
		}else {
			result = "Không tìm thấy sản phẩm nào cho '" + txtSearch + "'";
		}
		
		request.setAttribute("listProductNew", listProductNew);
		request.setAttribute("maintitle", result);
		request.setAttribute("ListAllProduct", list);
		request.setAttribute("txts", txtSearch);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
