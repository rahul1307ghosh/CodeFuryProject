<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>E-Asset MIS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<style type="text/css">
.bodyClass::-webkit-scrollbar {
	display: none;
}

.header {
	padding: 60px;
	text-align: center;
	background: -webkit-linear-gradient(left, #0072ff, #00c6ff);
	color: white;
	font-size: 30px;
}

.navbar-text {
	color: #f0ffff;
	font-size: 50px;
	font-weight: 600;
}

.nav-item a {
	color: white;
}

.card {
	border: none;
}

.card-header {
	padding: 30px;
	font-size: 30px;
}

.card-body {
	padding: 60px;
}

.card-text {
	padding: 20px;
	font-size: 18px;
}

#myBtn {
	display: none; /* Hidden by default */
	position: fixed; /* Fixed/sticky position */
	bottom: 20px; /* Place the button at the bottom of the page */
	right: 30px; /* Place the button 30px from the right */
	z-index: 99; /* Make sure it does not overlap */
	border: none; /* Remove borders */
	outline: none; /* Remove outline */
	background-color: red; /* Set a background color */
	color: white; /* Text color */
	cursor: pointer; /* Add a mouse pointer on hover */
	padding: 15px; /* Some padding */
	border-radius: 25px; /* Rounded corners */
	font-size: 18px;
	outline: none; /* Increase font size */
}

#myBtn:hover {
	background-color: #555; /* Add a dark-grey background on hover */
}

.feedback-form-main-container {
	background: -webkit-linear-gradient(left, #0072ff, #00c6ff);
	padding: 10px;
}

.feedback-form {
	background: #fff;
	margin-top: 10%;
	margin-bottom: 5%;
	width: 70%;
}

.feedback-form .form-control {
	border-radius: 1rem;
}

.contact-image {
	text-align: center;
}

.contact-image img {
	border-radius: 6rem;
	width: 11%;
	margin-top: -3%;
	transform: rotate(29deg);
}

.feedback-form form {
	padding: 14%;
}

.form-group {
	margin: 10px;
}

.feedback-form form .row {
	margin-bottom: -7%;
}

.feedback-form h3 {
	margin-bottom: 8%;
	margin-top: -10%;
	text-align: center;
	color: #0062cc;
}

.feedback-form .btnContact {
	width: 50%;
	border: none;
	border-radius: 1rem;
	padding: 1.5%;
	background: #dc3545;
	font-weight: 600;
	color: #fff;
	cursor: pointer;
}

.btnContactSubmit {
	width: 50%;
	border-radius: 1rem;
	padding: 1.5%;
	color: #fff;
	background-color: #0062cc;
	border: none;
	cursor: pointer;
}
</style>
</head>
<body class="bodyClass">
	<%
	if (request.getSession(true).getAttribute("popularAssetList") == null) {
		response.sendRedirect("home");
	}
	%>
	<div class="header">
		<div class="container-fluid">
			<span class="navbar-text">E-Asset Management </span>
		</div>
		<ul class="nav justify-content-center ">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="#">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="#feedback-link">Feedback</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Import
					Users</a>
				<h6>(Admin Only)</h6></li>
		</ul>
	</div>
	<div class="container">
		<div class="container-fluid">
			<div class="card">
				<div class="card-header">Welcome To E-Asset MIS</div>
				<div class="card-body">
					<h5 class="card-title">Manage Assets in a simple and better
						way</h5>
					<p class="card-text">The E-Asset Management system is a
						web-based application to keep track of several assets that can be
						borrowed, their availability, their current location, the current
						borrower and the asset history. This is the right place to borrow
						necessary resources responsibly.</p>
					<a href="register1.jsp" style="padding: 12px; margin: 5px;"
						class="btn btn-outline-primary">Register</a> <a href="login1.jsp"
						style="padding: 12px; margin: 5px;"
						class="btn btn-outline-primary">Login</a>
				</div>
			</div>
		</div>
		<hr>
		<div class="container-fluid">
			<div class="card-header">Popular Assets</div>
			<div class="container">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sr.no</th>
								<th scope="col">Allocation Count</th>
								<th scope="col">Name</th>
								<th scope="col">Type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${popularAssetList}">
								<tr>
									<td><c:out value="${user.dateAdded}" /></td>
									<td><c:out value="${user.isAvailable()}" /></td>
									<td><c:out value="${user.assetName}" /></td>
									<td><c:out value="${user.type}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<a id="feedback-link"></a>
		<div class="container-fluid feedback-form-main-container">
			<div class="container feedback-form">
				<div class="contact-image">
					<img src="https://image.ibb.co/kUagtU/rocket_contact.png"
						alt="rocket_contact" />
				</div>
				<form method="post">
					<h3>Give Us a Feedback</h3>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" name="txtName" class="form-control"
									placeholder="Your Name *" value="" />
							</div>
							<div class="form-group">
								<input type="text" name="txtEmail" class="form-control"
									placeholder="Your Email *" value="" />
							</div>
							<div class="form-group">
								<input type="text" name="txtPhone" class="form-control"
									placeholder="Your Phone Number *" value="" />
							</div>
							<div class="form-group">
								<input type="submit" name="btnSubmit" class="btnContact"
									value="Send Message" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea name="txtMsg" class="form-control"
									placeholder="Your Message *"
									style="width: 100%; height: 150px;"></textarea>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<button onclick="topFunction()" id="myBtn" title="Go to top">/\</button>
	<footer class="footer mt-auto py-3 bg-light">
		<div class="container">
			<span class="text-muted">A Product by Team Code Genesis</span>
		</div>
	</footer>
	<script type="text/javascript">
		//Get the button:
		mybutton = document.getElementById("myBtn");

		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction()
		};

		function scrollFunction() {
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}

		// When the user clicks on the button, scroll to the top of the document
		function topFunction() {
			document.body.scrollTop = 0; // For Safari
			document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
		}
	</script>
</body>
</html>