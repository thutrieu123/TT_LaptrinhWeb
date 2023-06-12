package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import model.Log;

public class LogDAO {
	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	public int insert(Log log) {
		DBContext db = DBContext.getInstance();
		try {
			connect = db.getConnection();
			String query = "INSERT INTO log (level, user, src, content, createAt, status) VALUES(?,?,?,?,NOW(),?)";
			ps = connect.prepareStatement(query);

			ps.setInt(1, log.getLevel());
			ps.setInt(2, log.getUserId());
			ps.setString(3, log.getContent());
			ps.setString(4, log.getSrc());

			ps.setInt(5, log.getStatus());
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

	public static void main(String[] args) throws SQLException {
		LogDAO logDB = new LogDAO();
		Log log = new Log(Log.DANGER, 001, "DoMinhPhu", "abc", 0);
		logDB.insert(log);
	}
}
