package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Category;
import model.Product;

public class ProductDAO {

	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public Product getProductById(int id) {
		DBContext db = new DBContext();
		Product product = null;
		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `products` WHERE products.id = ? ;";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				product = new Product(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
						result.getString(5), result.getInt(6));
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;

	}

	public List<Product> getProductSell(int status) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `products`where status = ? ;";
			ps = connect.prepareStatement(query);
			ps.setInt(1, status);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Lay tat ca san pham
	public List<Product> getAllProduct(int status) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `products` where status = ?;";
			ps = connect.prepareStatement(query);
			ps.setInt(1, status);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Lay tat ca san pham
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `products`;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Lay theo danh muc
	public List<Product> getProductByCategory(int catId) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT* FROM products WHERE products.DanhMuc_id = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, catId);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	// Lay ra san pham ban chay

	public List<Product> getProductSell() {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `products`;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Lay ra san pham moi
	public List<Product> getNewProduct() {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT * FROM `products` order BY id LIMIT 4;";
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Lay san pham theo ten
	public List<Product> getProductByName(String name) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "SELECT* FROM products WHERE products.name Like ?";
			ps = connect.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			result = ps.executeQuery();
			while (result.next()) {
				Product product = new Product(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				list.add(product);
			}
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public int update(Product product) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "UPDATE products SET products.name = ?,products.descreption = ?,products.price = ?,products.image =?,products.DanhMuc_id = ? WHERE id = ?;";
			ps = connect.prepareStatement(query);

			ps.setString(1, product.getName());
			ps.setString(2, product.getDescreption());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCatId());
			ps.setInt(6, product.getId());

			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
			return numberRowUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int changeStatus(int id, int status) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "UPDATE products SET status = ? WHERE id = ?;";
			ps = connect.prepareStatement(query);
			ps.setInt(1, status);
			ps.setInt(2, id);

			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
			return numberRowUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int delete(int id) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "Delete from products where id = ?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, id);
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
			return numberRowUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int insert(String name, String des, int price, String image, int catId) {
		DBContext db = new DBContext();
		try {
			connect = db.getConnection();
			String query = "INSERT INTO products(name,descreption,price,image,DanhMuc_id) VALUES(?,?,?,?,?);";
			ps = connect.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, des);
			ps.setInt(3, price);
			ps.setString(4, image);
			ps.setInt(5, catId);
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
			return numberRowUpdate;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int getTotalProduct() {
		DBContext db = new DBContext();
		String query = "select COUNT(*) from products";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	public int getTotalFood() {
		DBContext db = new DBContext();
		String query = "select COUNT(*) from products WHERE products.DanhMuc_id = 3";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	public int getTotalDrink() {
		DBContext db = new DBContext();
		String query = "select COUNT(*) from products WHERE products.DanhMuc_id = 3";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	public int getTotalCake() {
		DBContext db = new DBContext();
		String query = "select COUNT(*) from products WHERE products.DanhMuc_id = 1";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			result = ps.executeQuery();
			while (result.next()) {
				return result.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	public List<Product> pagingProduct(int index) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		String query = "SELECT * FROM products LIMIT ?,8;";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			ps.setInt(1, (index - 1) * 8);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new Product(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
						result.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> pagingFood(int index) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		String query = "SELECT * FROM products WHERE products.DanhMuc_id = 3  LIMIT ?,12";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			ps.setInt(1, (index - 1) * 12);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new Product(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
						result.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> pagingDrink(int index) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		String query = "SELECT * FROM products WHERE products.DanhMuc_id = 2  LIMIT ?,12";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			ps.setInt(1, (index - 1) * 12);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new Product(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
						result.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Product> pagingCake(int index) {
		List<Product> list = new ArrayList<>();
		DBContext db = new DBContext();
		String query = "SELECT * FROM products WHERE products.DanhMuc_id = 1  LIMIT ?,12";
		try {
			connect = db.getConnection();
			ps = connect.prepareStatement(query);
			ps.setInt(1, (index - 1) * 12);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new Product(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
						result.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
//		List<Product> list = productDAO.getProductByCateID("3");

	}

}