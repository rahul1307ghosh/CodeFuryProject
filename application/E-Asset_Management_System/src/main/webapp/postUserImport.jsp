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
											<h1 class="h4 text-gray-900 mb-4">Failed Import List:</h1>
										</div>
										<table class="table table-bordered">
											<thead>
												<tr>
													<th scope="col">Name</th>
													<th scope="col">Telephone</th>
													<th scope="col">Email</th>
													<th scope="col">Username</th>
												</tr>
												<c:forEach var="user" items="${list}">
													<tr>
														<td><c:out value="${user.name}" /></td>
														<td><c:out value="${user.telphone}" /></td>
														<td><c:out value="${user.email}" /></td>
														<td><c:out value="${user.userName}" /></td>
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
	<script type="text/javascript">
		alert("Operation was successfull...!")
	</script>
</body>
</html>