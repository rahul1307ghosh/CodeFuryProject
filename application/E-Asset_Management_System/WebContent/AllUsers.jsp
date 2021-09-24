<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

				<div class="col-xl-10 col-lg-10 col-md-10">

					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Users</h1>
										</div>
<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>UserName</th>
					<th>Last Login time</th>
				</tr>
					<tr>
						<td>Snehal</td>
						<td>smtg@gmail.com</td>
						<td>snehal</td>
						<td>dont kw</td>
					</tr>
			
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
</body>
</html>