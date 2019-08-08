package cn.trainning.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryData {

	private static String driver = "oracle.jdbc.driver.OracleDriver"; // 驱动

	private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl"; // 连接字符串

	private static String username = "scott"; // 用户名

	private static String password = "tiger"; // 密码

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
		Connection conn = getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Employee> empResult = new ArrayList<>();
		List<Department> deptResult = new ArrayList<>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (rs.next()) {

			if ("emp".equals(type)) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getString("EMPLOYEE_ID"));
				EMAIL
				PHONE_NUMBER
				HIRE_DATE
				JOB_ID
				SALARY
				COMMISSION_PCT
				MANAGER_ID
				DEPARTMENT_ID
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setHireDate(rs.getDate(columnIndex));
				emp.setJobId(rs.getInt(columnIndex));
				emp.setManagerId(managerId);
				emp.setDeptId(rs.getInt(columnIndex));
				emp.setSalary(salary);
				emp.setPhone(phone);
				return empResult;
			}
			if ("dept".equals(type)) {

				return deptResult;
			}
		}
		return null;
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
