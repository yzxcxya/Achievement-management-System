package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String url = null;
	private static String userName = null;
	private static String password = null;
	static{
		url = "jdbc:mysql://localhost:3306/Grade?useSSL=false";
		userName = "root";
		password = "123456";
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		//Class.forName("org.gjt.mm.mysql.Driver");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	
	public static void freeConnection(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
