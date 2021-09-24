<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<body>
	<jsp:include page="checkSession.jsp" />
	<div id="wrapper">
		<jsp:include page="sidebar.jsp" />
		<div id="content-wrapper" class="d-flex flex-column">
			<jsp:include page="topBar.jsp" />
			<div class="row justify-content-center">

				<div class="col-xl-8 col-lg-8 col-md-8">

					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Asset Category</h1>
										</div>
										<form action="addAssetCategory" method="POST">
											<div class="form-group">
												<input type="text" name="category"
													class="form-control form-control-user"
													id="exampleInputEmail" aria-describedby="emailHelp"
													placeholder="Category">
											</div>
											<div class="form-group">
												<input type="text" name="lendingPeriod"
													class="form-control form-control-user"
													id="exampleInputEmail" aria-describedby="emailHelp"
													placeholder="Lending Period">
											</div>
											<div class="form-group">
												<input type="text" name="lateReturnFee"
													class="form-control form-control-user"
													id="exampleInputEmail" aria-describedby="emailHelp"
													placeholder="Late Return Fee ">
											</div>
											<div class="form-group">
												<input type="text" name="daysBanned"
													class="form-control form-control-user"
													id="exampleInputEmail" aria-describedby="emailHelp"
													placeholder="Days banned ">
											</div>

											<div class="form-group">
												<input class="btn btn-primary btn-user btn-block"
													type="submit" value="Submit">
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
</body>
</html>
