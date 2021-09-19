<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asset Category</title>
</head>
<body>
	<form action="addAssetCategory" method="POST">
		<table>
			<tr>
				<td><lable>Category </lable></td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td><lable>Lending Period</lable></td>
				<td><input type="text" name="lendingPeriod"></td>
			</tr>
			<tr>
				<td><lable>Late Return Fee </lable></td>
				<td><input type="text" name="lateReturnFee"></td>
			</tr>
			<tr>
				<td><lable>Days banned </lable></td>
				<td><input type="text" name="daysBanned"></td>
			</tr>
			
			<tr><td><button type="submit">Submit</button></td></tr>
		</table>
	</form>
</body>
</html>