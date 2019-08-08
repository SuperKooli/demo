package cn.trainning.work;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QueryData {

	private static String driver = "oracle.jdbc.driver.OracleDriver"; //驱动

    private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl"; //连接字符串

    private static String username = "scott"; //用户名

    private static String password = "tiger"; //密码

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static List<? extends Object> getData(String type, String sql) {
		Connection  conn = getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while
	}
	
	public static void closeConnection(Connection conn, Statement stat, ResultSet rs) {
		try {
			conn.close();
			stat.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
