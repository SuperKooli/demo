<%@ page language="java" contentType="text/html; charset=UTF-8"   
    pageEncoding="UTF-8" isELIgnored="false"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SONY TRAINNING CLASS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form role="form" method="get" action="/Demo01/emp">
			<div class="form-group">
				<label for="name">Department</label> <select class="form-control">
			<option>1</option>
		</select> <label for="name">Manager</label> <select class="form-control">
			<option>1</option>
		</select> <label for="name">Job</label> <select class="form-control">
			<option>1</option>
		</select>
				<button type="submit" class="btn btn-default"
					style="display: inline;">查询</button>
			</div>
		</form>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PHONE</th>
					<th>EMAIL</th>
					<th>SALARY</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>NAME</td>
					<td>Anna</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>