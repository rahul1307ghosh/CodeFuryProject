<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="userLogin" method="POST">
		<table>
			<tr>
				<td>
					<label>Select user name or email for login</label> <br>
					<input type="radio" name="uname-email" value="username"><label>User Name</label>
					<input type="radio" name="uname-email" value="email"><label>User Email</label>
				</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td><lable>Password </lable></td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>

</body>
</html>