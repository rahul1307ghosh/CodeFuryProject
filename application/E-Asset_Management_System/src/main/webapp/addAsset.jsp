<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
						<option value="Laptop">Laptop</option>
						<option value="mobile">Mobile</option>
						<option value="device">Storage Device</option>
						
				</select></td>
			</tr>
			<tr>
				<td>Description</td>
			<td><textarea name="description"></textarea></td>
				
			
			</tr>
		    <tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add"></td>
			</tr>
			
		</table>
		</form>
</body>
</html>