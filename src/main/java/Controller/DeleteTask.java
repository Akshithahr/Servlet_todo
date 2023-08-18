package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletetask")
public class DeleteTask  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user")==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session Expired,Login Again</h1>");
			req.getRequestDispatcher("Login.html").include(req,resp);
		}
		else
		{
		
		
		resp.getWriter().print("<h1> This is deleted task Servlet</h1>");

	}
	}
}
