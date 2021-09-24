<%
if(session.getAttribute("adminData")==null)
{
	%>
	<jsp:forward page="login1.jsp" />
	<% 
}

%>