package OnlineSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddVote
 */
@WebServlet("/AddVote")
public class AddVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vote = request.getParameter("vote");
		String user = request.getParameter("u");
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loading.....");
			con = DriverManager.getConnection("jdbc:mysql://localhost/onlinevote","root","");
			String s = "insert into voted(username) value(?)";
			PreparedStatement pst =con.prepareStatement(s);
			pst.setString(1, user);
			pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(new Admin_Q().addVote(vote))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Thank.jsp");
			request.setAttribute("msg", "Thank you for voting");
			rd.forward(request, response);
			response.sendRedirect("Thank.jsp");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Thank.jsp");
			request.setAttribute("msg", "not voted");
			rd.forward(request, response);
		}
	}

}
