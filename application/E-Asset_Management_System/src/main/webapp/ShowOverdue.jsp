<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>E-Asset Managment System</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<jsp:include page="userSidebar.jsp" />
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>
					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">
						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>
						<div class="topbar-divider d-none d-sm-block"></div>
						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${userData.email}</span>
								<img class="img-profile rounded-circle"
								src="https://cdn-icons-png.flaticon.com/512/2345/2345337.png">
						</a></li>
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="abc.jsp" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fa fa-power-off"
								style="font-size: 20px; color: red"></i>
						</a></li>
					</ul>
				</nav>
				<div class="row justify-content-center">
					<div class="col-xl-10 col-lg-10 col-md-10">
						<div class="card o-hidden border-0 shadow-lg my-5">
							<div class="card-body p-0">
								<!-- Nested Row within Card Body -->
								<div class="row">
									<div class="col-lg-12">
										<div class="p-5">
											<div class="text-center">
												<h4>Overdue assets</h4>
												<table class="table">
													<thead>
														<tr>
															<th>Asset Id</th>
															<th>Asset Name</th>
															<th>Type</th>
															<th>Description</th>
															<th>Message from Admin</th>
														</tr>
														<c:forEach var="odmessage" items="${overdueList}">
															<tr>
																<td><c:out value="${odmessage.assetId}" /></td>
																<td><c:out value="${odmessage.assetName}" /></td>
																<td><c:out value="${odmessage.type}" /></td>
																<td><c:out value="${odmessage.desc}" /></td>
																<td><c:out value="${odmessage.message}" /></td>
															</tr>
														</c:forEach>
													</thead>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Bootstrap core JavaScript-->
			<script src="vendor/jquery/jquery.min.js"></script>
			<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
			<!-- Core plugin JavaScript-->
			<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
			<!-- Custom scripts for all pages-->
			<script src="js/sb-admin-2.min.js"></script>
			<!-- Page level plugins -->
			<script src="vendor/chart.js/Chart.min.js"></script>
			<!-- Page level custom scripts -->
			<script src="js/demo/chart-area-demo.js"></script>
			<script src="js/demo/chart-pie-demo.js"></script>
</body>
</html>