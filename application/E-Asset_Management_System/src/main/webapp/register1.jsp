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
										<h1 class="h4 text-gray-900 mb-4">Registartion</h1>
									</div>
									<form action="registerUser" method="POST">
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												name="uname" placeholder="Enter Name..." required>
										</div>
										<div class="form-group">
											<input type="text" name="telephone"
												class="form-control form-control-user"
												id="exampleInputPassword" placeholder="Enter Telephone no.."
												required>
										</div>
										<div class="form-group">
											<input type="email" name="email"
												class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												name="uname" placeholder="Enter Email..." required>
										</div>
										<div class="form-group">
											<input input type="text" name="userName"
												class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												name="uname" placeholder="Enter UserName..." required>
										</div>
										<div class="form-group">
											<input type="password" name="pwd1"
												class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												name="uname" placeholder="Enter Password" required>
										</div>
										<div class="form-group">
											<input type="password" name="pwd2"
												class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												name="uname" placeholder="Confirm Password" required>
										</div>


										<hr>

										<div class="text-center">
											<button class="btn btn-primary btn-user btn-block"
												type="submit">Create an Account!</button>
										</div>
										<hr>
										<div class="text-center">
											<a class="btn btn-link" href="home.jsp">Go Back</a>
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

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

</body>

</html>