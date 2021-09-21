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


	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>UserName</th>
				<th>Last Login time</th>
			</tr>
			<tr>
				<td><c:out value="${userData.name}" /></td>
				<td><c:out value="${userData.email}" /></td>
				<td><c:out value="${userData.userName}" /></td>
				<td><c:out value="${userData.lastLogin}" /></td>
			</tr>

		</thead>
	</table>
	
	<div class="container">
		<h4>Borrowed assets list</h4>
		<table class="table">
			<thead>
				<tr>
					<th>Allocation Id</th>
					<th>Asset Name</th>
					<th>Type</th>
					<th>Description</th>
					<th>Date of Allocation</th>
					<th>Due date</th>
					<th>Late Fee</th>
				</tr>
				<c:forEach var="assets" items="${borrowedAssets}">
					<tr>
						<td><c:out value="${assets.allocationId}" /></td>
						<td><c:out value="${assets.assetName}" /></td>
						<td><c:out value="${assets.type}" /></td>
						<td><c:out value="${assets.desciption}" /></td>
						<td><c:out value="${assets.allocation_date}" /></td>
						<td><c:out value="${assets.due_date}" /></td>
						<td><c:out value="${assets.late_fee}" /></td>
					</tr>
				</c:forEach>
			</thead>
		</table>
	</div>

	<form action="BorrowAsset" method="get"
		onsubmit="return validateData()">

		<tr>
			<td>Asset Type :</td>
			<td><select name="Asset" id="asset">
					<option>-----select one-----</option>
					<option value="Laptop">Laptop</option>
					<option value="Mobile">Mobile</option>
					<option value="Devices">Devices</option>
					<option value="Books">Books</option>
					<option value="Headset">Headset</option>
					<option value="Keyboard">Keyboard</option>
					<option value="Mouse">Mouse</option>
			</select></td>
			<td></td>
		</tr>
		<br> <br>
		<button type="submit" name="btn" value="${BorrowAsset.id}">Add
			More Asset</button>
		<button type="submit" name="btn" value="${BorrowAsset.id}">Borrow
			Asset</button>
	</form>


</body>
</html>