<%@page import="com.hsbc.entity.Overdue"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
@SuppressWarnings("unchecked")
List<Overdue> List = (List<Overdue>) session.getAttribute("list1");
if (List.size() > 0) {
%>
<table class="table">
	<thead>
		<tr>
			<th>Name(Borrower)</th>
			<th>Email</th>
			<th>Asset Name</th>
			<th>Category</th>
			<th>DueDate</th>
			<th></th>



		</tr>
		<%
		for (Overdue e : List) {
		%>
		<tr>
			<td><%=e.getUserName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getAssetName()%></td>
			<td><%=e.getCategory()%></td>

			<td><%=e.getDue_date()%></td>
			<td><button class="btn btn-success"
					onclick="sendMsg(<%=e.getUserId()%>,<%=e.getAssetId()%>)">Send
					Message</button></td>
			<td>
				<div id=<%=e.getUserId()%>></div>
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