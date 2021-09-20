<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
</head>
<body>

    <p>Admin</p>
 
 	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>UserName</th>
				<th>Last Login time</th>
			</tr>
			<tr>
				<td><c:out value="${adminData.name}" /></td>
				<td><c:out value="${adminData.email}" /></td>
				<td><c:out value="${adminData.userName}" /></td>
				<td><c:out value="${adminData.lastLogin}" /></td>
			</tr>

		</thead>
	</table>
    
   
    <p><a href="getAssetCategory"><button >Add Asset</button></a></p>
  
    <p><a href="overDue.jsp"><button >Over Due Asset</button></a></p>
  
 
</body>
</html>