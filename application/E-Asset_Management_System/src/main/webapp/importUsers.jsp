<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<body>
	<jsp:include page="checkSession.jsp" />
	<div id="wrapper">
		<jsp:include page="sidebar.jsp" />
		<div id="content-wrapper" class="d-flex flex-column">
			<jsp:include page="topBar.jsp" />
			<!-- Outer Row -->
			<div class="row justify-content-center">
				<div class="col-xl-8 col-lg-8 col-md-8">
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Import Users</h1>
										</div>
										<form action="importUsers" method="POST"
											enctype="multipart/form-data">
											<div class="form-group row">
												<input type="file" class="border col-8"
													accept="application/JSON" name="file" /> <span
													class="col-1"></span>
												<button class="btn btn-primary btn-user col-3" type="submit">Import
													Users</button>
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