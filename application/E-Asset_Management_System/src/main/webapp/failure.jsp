<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<body>
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
											<h1 class="h4 text-danger mb-4">Operation is Unsuccesful</h1>
										</div>
										

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