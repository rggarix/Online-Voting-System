<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h2>Online Voting System</h2></center>
<center>
	<form action="LoginC" method="post">
		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><a href="Signup.jsp"><input type="button" value="SignUp"></a></td>
			</tr>
		</table>
	</form>
</center>
<center>
<%
	if(request.getAttribute("msg")!=null)
	{
		
%>
<h2><%=request.getAttribute("msg") %></h2>
<%
	}
%>
</center>
</body>
</html>