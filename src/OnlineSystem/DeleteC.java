package OnlineSystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteC
 */
@WebServlet("/DeleteC")
public class DeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String partyname = request.getParameter("pname");
		
		if(new Admin_Q().delete(name, partyname))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
			request.setAttribute("msg", name);
			rd.forward(request, response);
			response.sendRedirect("Admin.jsp");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
			request.setAttribute("msg", "not deleted");
			rd.forward(request, response);
		}
	}

}
