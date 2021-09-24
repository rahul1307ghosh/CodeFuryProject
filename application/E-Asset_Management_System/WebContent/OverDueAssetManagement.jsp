<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<body>
 <div id="wrapper">
<jsp:include page="sidebar.jsp" />
	<h2>Enter details : </h2>
	<form action="assetoverdueMangg" method="post">
		<table>
			<tr>
				<td>Asset Id :</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="assetId"></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><input type="text" name="message"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"></td>
			</tr>
		</table>
	</form>
	<a href="admin.jsp">Go to Main page</a>
</body>
</html>