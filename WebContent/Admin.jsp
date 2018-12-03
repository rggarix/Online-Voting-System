<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(request.getAttribute("msg")!=null)
	{
		
%>
<h2 style="color: red;">Welcome  <%=request.getAttribute("msg") %></h2>
<%
	}
%>

<table>
	<tr>
		<td><h3>Add Candidate</h3></td>
		<td><a href="AddDetail.jsp"><input type="button" value="Add"></a></td>
	</tr>
	<tr>
		<td><h3>Delete Candidate</h3></td>
		<td><a href="Delete.jsp"><input type="button" value="Delete"></a></td>
	</tr>
	<tr>
		<td><h3>Result</h3></td>
		<td><a href="Result.jsp"><input type="button" value="Result"></a></td>
	</tr>
	<tr>
		<td></td>
		<td><a href="Logout"><input type="button" value="Logout"></a></td>
	</tr>
</table>

</body>
</html>