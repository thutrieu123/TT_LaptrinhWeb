package admin;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId = request.getParameter("proId");
		ProductDAO productDAO = new ProductDAO();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
