<%@page import="com.hsbc.entity.Overdue"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />

<script type="text/javascript">
	function changeFunc() {
		var selectBox = document.getElementById("selectBox");
		var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = handleResponse1
		xhr.open("POST", "assetoverdueManagment", true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xhr.send("sortBy=" + selectedValue)
	}
	function handleResponse1() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				document.getElementById("resp").innerHTML = xhr.responseText
			} else {
				document.getElementById("resp").innerHTML = xhr.responseText
			}
		}
	}
	var userid
	function sendMsg(userId, assetId, i) {
		xhr = new XMLHttpRequest();
		userid = i;
		xhr.onreadystatechange = handleResponse
		xhr.open("POST", "AssetoverdueMangg", true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		xhr.send("userId=" + userId + "&assetId=" + assetId)

	}
	function handleResponse() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var res = xhr.responseText
				document.getElementById(userid).innerHTML = xhr.responseText

			} else {
				document.getElementById("resp").innerHTML = xhr.responseText
			}
		}
	}
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
										<div class="form-group">
											<select class="form-control" id="selectBox"
												onchange="changeFunc();">
												<option value="due_date">Date</option>
												<option value="name">Name</option>
												<option value="category">Category</option>
											</select>
										</div>
										<div id="resp" class="form-group">
											<jsp:include page="tableData.jsp" />
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