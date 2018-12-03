package OnlineSystem;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.stream.FileImageInputStream;



public class Admin_Q {
	Connection con = null;
    public Connection getConnection()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loading.....");
		con = DriverManager.getConnection("jdbc:mysql://localhost/onlinevote","root","");
		return con;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void close()
	{
		if(con==null)
		{
			try
			{
				con.close();
				con= null;
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public boolean addVote(String vote)
	{
		int count=0;
		try {
			if(con==null)
			{
				getConnection();
			}
			
			String s="insert into vote(vote) value(?)";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, vote);
			
			count=pst.executeUpdate();
			if(count>0)
			{
				System.out.println("added..");
				close();
				return true;
			}
			else
			{
			close();
			System.out.println("failed..........");
			return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			close();
			return false;
		}
	}
	
	public boolean addcandidate(String name , String partyname , String location)
	{
		int count=0;
		try {
			if(con==null)
			{
				getConnection();
			}
			
			String s="insert into candidate(name,partyname,location) value(?,?,?)";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, name);
			pst.setString(2, partyname);
			pst.setString(3, location);
			
			count=pst.executeUpdate();
			if(count>0)
			{
				System.out.println("added..");
				close();
				return true;
			}
			else
			{
			close();
			return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			close();
			return false;
		}
	}
	
	public boolean delete(String name,String partyname)
	{
		
		try {
			if(con==null)
			{
				getConnection();
			}
			
			String s="delete from candidate where name=? and partyname=?";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, name);
			pst.setString(2, partyname);
			pst.executeUpdate();
			
			close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			close();
			return false;
		}
	}
	
	public static void main(String[] args) {
		

	}

}
