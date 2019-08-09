package cn.trainning.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.trainning.dao.EmpDeptJobDao;
import cn.trainning.dto.Department;
import cn.trainning.dto.Employee;
import cn.trainning.dto.Job;

/**
 * Servlet implementation class Test
 */
@WebServlet("/emp")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept = request.getParameter("department_id");
		String manager = request.getParameter("manager_id");
		String job = request.getParameter("job_id");
		StringBuffer sql = new StringBuffer("select * from employees where 1 = 1 ");
		if(!"".equals(dept)) {
			sql.append("and dept = " + dept);
		}
		if(!"".equals(manager)) {
			sql.append("and manager = " + manager);
		}
		if(!"".equals(job)) {
			sql.append("and job = " + job);
		}
		List<Employee> empList = (List<Employee>) new EmpDeptJobDao().getDate("emp", sql.toString());
		List<Department> depts = (List<Department>) new EmpDeptJobDao().getDate("dept", "select department_id from departments");
		List<Employee> managers = (List<Employee>) new EmpDeptJobDao().getDate("emp", "select manager_id from employees");
		List<Job> jobs = (List<Job>) new EmpDeptJobDao().getDate("job", "select job_id from jobs");
		request.setAttribute("empList", empList);
		request.setAttribute("depts", depts);
		request.setAttribute("managers", managers);
		request.setAttribute("jobs", jobs);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
