package cn.trainning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.trainning.dto.Department;
import cn.trainning.dto.Employee;
import cn.trainning.dto.Job;

public class EmpDeptJobDao {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	String user = "scott";
	String password = "tiger";

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);// 连接数据库
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 加载数据驱动

		return conn;
	}

	public List<? extends Object> getDate(String type, String sql) {
		List<Employee> empResult = new ArrayList<>();
		List<Department> deptResult = new ArrayList<>();
		List<Job> jobResult = new ArrayList<>();
		Connection con = this.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if ("emp".equals(type)) {
			try {
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
					emp.setFirstName(rs.getString("FIRST_NAME"));
					emp.setLastName(rs.getString("LAST_NAME"));
					emp.setEmail(rs.getString("EMAIL"));
					emp.setPhone(rs.getString("PHONE_NUMBER"));
					emp.setHireDate(rs.getDate("HIRE_DATE"));
					emp.setJobId(rs.getString("JOB_ID"));
					emp.setSalary(rs.getDouble("SALARY"));
					emp.setManagerId(rs.getInt("MANAGER_ID"));
					emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
					empResult.add(emp);
				}
				this.closeConnection(con, stat, rs);
				return empResult; 

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ("dept".equals(type)) {
			try {
				while (rs.next()) {
					Department dept = new Department();
					dept.setDeptId(rs.getInt("DEPARTMENT_ID"));
					dept.setDeptName(rs.getString("DEPARTMENT_NAME"));
					dept.setManagerId(rs.getInt("MANAGER_ID"));
					dept.setLocationId(rs.getInt("LOCATION_ID"));
					deptResult.add(dept);
				}
				this.closeConnection(con, stat, rs);
				return deptResult;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if("job".equals(type)) {
			try {
				while (rs.next()) {
					Job job = new Job();
					job.setJobId(rs.getString("JOB_ID"));
					job.setJobTitle(rs.getString("JOB_TITLE"));
					job.setMinSalary(rs.getInt("MIN_SALARY"));
					job.setMaxSalary(rs.getInt("MAX_SALARY"));
					jobResult.add(job);
				}
				this.closeConnection(con, stat, rs);
				return jobResult;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

	public void closeConnection(Connection con, Statement stat, ResultSet rs) {
		try {
			rs.close();
			stat.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
