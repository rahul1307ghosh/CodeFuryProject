
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<%
if(session.getAttribute("adminData")==null)
{
	%>
	<jsp:forward page="login1.jsp" />
	<% 
}

%>

</body>
</html>