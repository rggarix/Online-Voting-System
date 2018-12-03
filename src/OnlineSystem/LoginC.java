package OnlineSystem;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginC
 */
@WebServlet("/LoginC")
public class LoginC extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		if(new MyUser().checkuser(username, password))
		{
			try
			{
				Integer.parseInt(username);
				if(new MyUser().userauthenticate(username))
				{
					RequestDispatcher rd = request.getRequestDispatcher("/Already.jsp");
					request.setAttribute("msg", "Thank You .....You have Already Voted!!!!!");
					rd.forward(request, response);
					response.sendRedirect("Already.jsp");
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
					request.setAttribute("msg", username);
					rd.forward(request, response);
					response.sendRedirect("Home.jsp");
				}
			}
			catch (NumberFormatException e) {
				RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
				request.setAttribute("msg", username);
				rd.forward(request, response);
				response.sendRedirect("Admin.jsp");
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
			request.setAttribute("msg", "the password is wrong");
			rd.forward(request, response);
		}
	}

}
