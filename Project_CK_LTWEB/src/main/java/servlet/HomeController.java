package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO productDAO = new ProductDAO();
		String indexPage = request.getParameter("index");
		if(indexPage==null) {
			indexPage="1";
		}
		int index = Integer.parseInt(indexPage);
		
		int count = productDAO.getTotalProduct();
		int endPage = count / 8;
		if (count % 8 != 0) {
			endPage++;
		}

		List<Product> listProductNew = productDAO.getNewProduct();
		List<Product> listPaging = productDAO.pagingProduct(index);
		
		request.setAttribute("listProductNew", listProductNew);	
		
		request.setAttribute("maintitle", "Tất cả sản phẩm");
		request.setAttribute("ListAllProduct", listPaging);
		request.setAttribute("endP", endPage);

		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
