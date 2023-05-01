package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/loadMore")
public class LoadMoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoadMoreController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String amount = request.getParameter("exits");
		int iamount = Integer.parseInt(amount); 
		ProductDAO productDAO = new ProductDAO();

		List<Product> list = productDAO.getNext4Product(iamount);

		PrintWriter out = response.getWriter();
		for (Product o : list) {
			out.println("<div class=\"product row\">\n"
					+ "						<form method=\"POST\" action=\"CartController\">\n"
					+ "							<div class=\"col-md-4 col-sm-2 product\">\n"
					+ "								<div class=\"card  is-table-row\" style=\"width: 14.5rem;\">\n"
					+ "									<a href=\"product?proId=" + o.getId()
					+ "\"><input type=\"hidden\"\n" + "										name=\"proId\" value=\\"
					+ o.getId() + "\"><input\n"
					+ "										type=\"hidden\" name=\"inputQuantity\" value=\"1\"> <img\n"
					+ "										src=\"" + o.getImage()
					+ "\" class=\"card-img-top\" alt=\"...\"></a>\n"
					+ "									<div class=\"card-body\">\n"
					+ "										<a href=\"product?proId=" + o.getId() + "\"><h5\n"
					+ "												class=\"card-title show_txt\">\n"
					+ "												<b>" + o.getName() + "</b>\n"
					+ "											</h5></a>\n"
					+ "										<p class=\"card-text show_txt\">" + o.getDescreption()
					+ "</p>\n" + "										<b>Giá: " + o.getPrice() + " VNĐ.</b>\n"
					+ "										<button style=\"margin-top: 4px;\" type=\"submit\"\n"
					+ "											class=\"btn btn-outline-success\">\n"
					+ "											<i class=\"ti-shopping-cart icon-black\"></i> Thêm vào giỏ\n"
					+ "										</button>\n"
					+ "									</div>\n" + "								</div>\n"
					+ "							</div>\n" + "						</form>\n"
					+ "					</div>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
