package OnlineSystem;

import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class AddD
 */
@WebServlet("/AddD")
public class AddD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024*1024*50;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) 
		{
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			writer.flush();
			return;
		}
		Connection con;
		
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE); 
		
		String uploadPath = getServletContext().getRealPath("")+ File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		
		if (!uploadDir.exists()) 
		{
			uploadDir.mkdir();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loading.....");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/onlinevote","root","");
			
			
			List formItems = upload.parseRequest((RequestContext) request);
			Iterator iter = formItems.iterator();
			String filePath = null;
			while (iter.hasNext()) 
			{
				
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) 
				{
					String fileName = new File(item.getName()).getName();
					filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					item.write(storeFile);
				}
			}
		
		
		String name =request.getParameter("name");
		String partyname =request.getParameter("pname");
		String location =request.getParameter("loca");
		
		 
		 int count=0;
			 
				String s="insert into detail(name,partyname,pic,partylogo,location) value(?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(s);
				
				pst.setString(1, name);
				pst.setString(2, partyname);
				pst.setString(3, filePath);
				pst.setString(5, location);
				
				count =pst.executeUpdate();
				if(count>0)
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
		 }catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed......");
		}
		
	}

}
