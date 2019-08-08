package cn.trainning.work;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/emp")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("empInfo"));
		response.getWriter().append("<table class=\"table table-striped\">")
		.append("<thead>\r\n" + 
				"			<tr>\r\n" + 
				"				<th>EMPID</th>\r\n" + 
				"				<th>FIRST NAME</th>\r\n" + 
				"				<th>LAST NAME</th>\r\n" + 
				"				<th>EMAIL</th>\r\n" + 
				"				<th>PHONE</th>\r\n" + 
				"				<th>JOB ID</th>\r\n" + 
				"				<th>SALARY</th>\r\n" + 
				"				<th>MANAGER ID</th>\r\n" + 
				"				<th>DEPT ID</th>\r\n" + 
				"			</tr>\r\n" + 
				"		</thead>")
		.append("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
