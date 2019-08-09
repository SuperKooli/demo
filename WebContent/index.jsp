<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="cn.trainning.dto.Employee"%>
<%@page import="cn.trainning.dto.Department"%>
<%@page import="cn.trainning.dto.Job"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Employees</title>
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3">
				<form action="/0809">
					<div class="form-group">
						<label for="department_id" class="col-lg-2 control-label">Department</label>
						<div class="col-lg-10">
							<select class="form-control" id="department_id"
								name="department_id" placeholder="Sales" onchange="this.form.submit();">
								<c:forEach var="dept" items="${depts}">
									<c:if test="${dept.departmentId==requestScope.departmentId }">
										<option value="${dept.departmentId }" selected="selected">${dept.departmentName }</option>
									</c:if>
									<c:if test="${dept.departmentId!=requestScope.departmentId }">
										<option value="${dept.departmentId }">${dept.departmentName }</option>
									</c:if>
								</c:forEach>
							</select>  
						</div>
							<label for="manager_id" class="col-lg-2 control-label">Manager</label>
						<div class="col-lg-10">
							<select class="form-control" id="manager_id"
								name="manager_id" placeholder="Sales" onchange="this.form.submit();">
								<c:forEach var="manager" items="${managers}">
									<c:if test="${manager.managerId==requestScope.managerId }">
										<option value="${manager.managerId }" selected="selected">${manager.managerId }</option>
									</c:if>
									<c:if test="${manager.managerId!=requestScope.managerId }">
										<option value="${manager.managerId }">${manager.managerId }</option>
									</c:if>
								</c:forEach>
							</select>  
						</div>
							<label for="job_id" class="col-lg-2 control-label">Job</label>
						<div class="col-lg-10">
							<select class="form-control" id="manager_id"
								name="job_id" placeholder="Sales" onchange="this.form.submit();">
								<c:forEach var="job" items="${jobs}">
									<c:if test="${job.managerId==requestScope.jobId }">
										<option value="${job.jobId }" selected="selected">${job.jobId }</option>
									</c:if>
									<c:if test="${job.jobId!=requestScope.managerId }">
										<option value="${job.jobId }">${job.jobId }</option>
									</c:if>
								</c:forEach>
							</select>  
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</form>
			</div>
		</div><br>
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-bordered">
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>						
						<th>SALARY</th>
					</tr>
					<c:forEach items="${empList }" var="emp">
						<tr>
							<td><c:out value="${emp.employeeId }" /></td>
							<td><c:out value="${emp.name }" /></td>
							<td><c:out value="${emp.phoneNumber }" /></td>
							<td><c:out value="${emp.email }" /></td>							
							<td><c:out value="${emp.salary }" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</body>
</html>