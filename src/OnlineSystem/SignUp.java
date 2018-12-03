package OnlineSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String username =request.getParameter("user");
		String password =request.getParameter("pass");

		if(new MyUser().addUser(name, username, password))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				request.setAttribute("msg", "");
				rd.forward(request, response);
				response.sendRedirect("Login.jsp");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
				request.setAttribute("msg", "the signup is not processed.. Signup again.");
				rd.forward(request, response);
			}
		
	}

}
