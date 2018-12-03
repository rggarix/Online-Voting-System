<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: blue;">Online Voting</h1>

<%
if(request.getAttribute("msg")!=null)
{
	String m=String.valueOf(request.getAttribute("msg"));
	System.out.println(m);
	Connection con=null;
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loading.....");
	con = DriverManager.getConnection("jdbc:mysql://localhost/onlinevote","root","");
	
	String s="select * from candidate";
	PreparedStatement pst=con.prepareStatement(s);
	ResultSet rs=pst.executeQuery();
%>
	<form action="AddVote" method="post">
	<table>
	<tr>
		<td>Vote By</td>
		<td><input type="text" value="<%= String.valueOf(request.getAttribute("msg")) %>" name="u"></td>
	</tr>
<%		
	while(rs.next())
	{
	
%>
		<tr>
		<td><h2><%=rs.getString("name") %></h2></td>
		</tr>
		<tr>
		<td><h3><%=rs.getString("partyname") %></h3></td>
		<td><input type="radio" name="vote" value="<%=rs.getString("id") %>"></td>
		</tr>
		<tr>
		<td><h3><%=rs.getString("location") %></h3></td>
		</tr>
			
	</table>

<%
	}
%>
<input type="submit" value="Vote">
<a href="Logout"><input type="button" value="Logout"></a>
<%
}
%>
</form>
</body>
</html>