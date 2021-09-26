<%@page import="com.hsbc.entity.Overdue"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />

<script type="text/javascript">
	
</script>
<body>
<jsp:include page="checkSession.jsp" />
	<div id="wrapper">

		<jsp:include page="sidebar.jsp" />
		<div id="content-wrapper" class="d-flex flex-column">
			<jsp:include page="topBar.jsp" />
			<!-- Outer Row -->
			<div class="row"></div>
			<div class="row justify-content-center">

				<div class="col-xl-11 col-lg-11 col-md-11">

					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-12">
									<div class="p-5">

										<div id="resp" class="form-group">
											<%
											@SuppressWarnings("unchecked")
																				List<Overdue> List = (List<Overdue>) session.getAttribute("assetList");
																				if (List.size() > 0) {
																					int i = 1;
											%>
											<table class="table table-bordered">
												<thead>
													<tr>
														<th>Sr.no</th>
														<th>Name(Borrower)</th>
														<th>Email</th>
														<th>Asset Name</th>
														<th>Category</th>




													</tr>
													<%
													for (Overdue e : List) {
													%>
													<tr>
														<td><%=i++%></td>
														<td><%=e.getUserName()%></td>
														<td><%=e.getEmail()%></td>
														<td><%=e.getAssetName()%></td>
														<td><%=e.getCategory()%></td>


														</td>

													</tr>
													<%
													}
													%>
												</thead>
											</table>
											<%
											}
											%>
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