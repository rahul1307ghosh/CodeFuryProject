<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
									</div>
									<form action="userLogin" method="POST">
										<div class="form-group">

											<span class="label label-info">Select user name or
												email for login</span><br>

											<div class="custom-control custom-radio">
												<input type="radio" name="uname-email" value="username"
													required><label>User Name</label>

											</div>

											<div class="custom-control custom-radio">
												<input type="radio" name="uname-email" value="email"
													required><label>User Email</label>
											</div>

											<div class="form-group">
												<input type="text" name="userName"
													class="form-control form-control-user"
													id="exampleInputEmail" aria-describedby="emailHelp"
													placeholder="Enter your choice" required>
											</div>
											<div class="form-group">
												<input type="password" name="pwd"
													class="form-control form-control-user"
													id="exampleInputPassword" placeholder="Password" required>
											</div>

											<div class="form-group">
												<input class="btn btn-primary btn-user btn-block"
													type="submit" value="Login">
											</div>
											<hr>

											<div class="text-center">
												<a class="btn btn-link" href="home.jsp">Go Back</a>
											</div>
										</div>
									</form>


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
</body>

</html>