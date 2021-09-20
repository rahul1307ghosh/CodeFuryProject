<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<form action="addAsset" method="POST">
		<table>
			<tr>
				<td><lable>Name </lable></td>
				<td><input type="text" name="uname"></td>
			</tr>

			<tr>
				<td>Category</td>
				<td><select name="category">
						<c:forEach var="emp" items="${catList}">
							<option value="${emp.category}">${emp.category}</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description"></textarea></td>


			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" style="padding:10px;" class="btn-primary" value="Add"></td>
				<td colspan="2" align="center"><a href="assetCategory.jsp" style="padding:10px;text-decoration: none;" class="btn-primary">Add Category</a></td>
			</tr>

		</table>
	</form>
</body>
</html>