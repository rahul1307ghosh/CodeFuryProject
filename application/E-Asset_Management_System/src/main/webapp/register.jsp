<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="registerUser" method="POST">
		<table>
			<tr>
				<td><lable>Name </lable></td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td><lable>Role </lable></td>
				<td><input type="text" name="role"></td>
			</tr>
			<tr>
				<td><lable>Telephone </lable></td>
				<td><input type="text" name="telephone"></td>
			</tr>
			<tr>
				<td><lable>Email </lable></td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td><lable>User Name </lable></td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td><lable>Password </lable></td>
				<td><input type="password" name="pwd1"></td>
			</tr>
			<tr>
				<td><lable>Confirm Password </lable></td>
				<td><input type="password" name="pwd2"></td>
			</tr>
			<tr><td><button tyep="submit">Register</button></td></tr>
		</table>
	</form>
</body>
</html>