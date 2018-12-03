<%@page import="java.util.Arrays"%>
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
<center><h1>Result</h1></center>
<%
	Connection con=null;
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loading.....");
	con = DriverManager.getConnection("jdbc:mysql://localhost/onlinevote","root","");
	
	String s="Select * from candidate";
	PreparedStatement pstm = con.prepareStatement(s);
	ResultSet rs1=pstm.executeQuery();
	int[] arr = new int[100];
	int i =0;
	while(rs1.next())
	{
		int temp = rs1.getInt("id");
			arr[i]=temp;
				i++;
			
	}
	
	String sql="Select * from vote";
	PreparedStatement pst = con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	int[] v = new int[i+1];
	while(rs.next())
	{
		int t=rs.getInt("vote");
		for(int k =0;k<i;k++)
		{
			if(t==arr[k])
			{
				v[k]=v[k]+1;
			}
		}
		
	}
	int sum=0 ,max=0 ,index=0;
	for(int j =0;j<i;j++)
	{
		sum=sum+v[j];
		if(v[j]>max)
		{
			max=v[j];
			index=j;
		}
	}
	for(int l=0;l<i;l++)
	{
%>
	<h3>Party Name :<%=arr[l] %></h3>  <h3>Vote :<%=v[l] %></h3>
<% 
	}
%>
<h2>Total Vote : <%=sum %>         Winner : <%=arr[index] %></h2>
</body>
</html>