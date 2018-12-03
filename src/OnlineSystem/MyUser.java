package OnlineSystem;

import java.sql.*;

public class MyUser {
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
	    public boolean checkuser(String username,String password)
	    {
	    	try
	    	{
	    	if(con==null)
	    	{
	    		getConnection();
	    	}
	    			String q="select * from user where username=? and password=?";
	    			PreparedStatement pst = con.prepareStatement(q);
	    			pst.setString(1, username);
	    			pst.setString(2, password);
	    			
	    			ResultSet rs = pst.executeQuery();
	    			if(rs.next())
	    			{
	    				close();
	    				System.out.println("correct....");
	    				return true;
	    			}
	    			else
	    			{
	    				close();
	    				return false;
	    			}
	    		}catch (Exception e) {
					e.printStackTrace();
					System.out.println("failed.......");
					return false;
				}
	    }
	    public boolean userauthenticate(String username)
	    {
	    	try
	    	{
	    	if(con==null)
	    	{
	    		getConnection();
	    	}
	    			String q="select * from voted where username=?";
	    			PreparedStatement pst = con.prepareStatement(q);
	    			pst.setString(1, username);
	    			
	    			ResultSet rs = pst.executeQuery();
	    			if(rs.next())
	    			{
	    				close();
	    				System.out.println("correct....");
	    				return true;
	    			}
	    			else
	    			{
	    				close();
	    				return false;
	    			}
	    		}catch (Exception e) {
					e.printStackTrace();
					System.out.println("failed.......");
					return false;
				}
	    }
	    
	    public boolean addUser(String name , String username ,String password)
	    {
	    	try
	    	{
	    	if(con==null)
	    	{
	    		getConnection();
	    	}
	    		String s="insert into user(name,username,password) value(?,?,?)";
	    		PreparedStatement pst =con.prepareStatement(s);
	    		pst.setString(1, name);
	    		pst.setString(2, username);
	    		pst.setString(3, password);
	    		
	    		pst.executeUpdate();
	    		System.out.println("added...");
	    		close();
	    		return true;
	    	}
	    	catch (Exception e) {
				e.printStackTrace();
				System.out.println("failed.....");
				return false;
			}
	    }
	public static void main(String[] args) {
		
	}

}
