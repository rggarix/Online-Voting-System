<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>SignUp</h1></center>
<center>
<form action="SignUp" method="post">
	<table>
		<tr>
			<td>Enter Name:</td>
			<td><input type="text" name="name" placeholder="Enter Name"></td>
		</tr>
		<tr>
			<td>Enter Username:</td>
			<td><input type="text" name="user" placeholder="user should enter addhar no."></td>
		</tr>
		<tr>
			<td>Enter Password:</td>
			<td><input type="password" name="pass" placeholder="Enter Password"></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="SignUp"></td>
		</tr>
	</table>
</form>
</center>
<%
	if(request.getAttribute("msg")!=null)
	{
%>
<center><h2 style="color: red;"><%=request.getAttribute("msg")%></h2></center>
<%
	}
%>
</body>
</html>