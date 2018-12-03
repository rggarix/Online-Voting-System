package OnlineSystem;

import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;



/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddDetail")

public class AddDetail extends HttpServlet {
	
	
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String name =request.getParameter("name");
		String partyname =request.getParameter("pname");
		String location =request.getParameter("loca");
		
		if(new Admin_Q().addcandidate(name, partyname, location))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
			request.setAttribute("msg", "");
			rd.forward(request, response);
			response.sendRedirect("Admin.jsp");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
			request.setAttribute("msg", "not added");
			rd.forward(request, response);
		}
		
		
	}

	
	
}
