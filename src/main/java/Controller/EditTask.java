package Controller;

	import java.io.IOException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

	@WebServlet("/edittask")
	public class EditTask extends HttpServlet {
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			if(req.getSession().getAttribute("user")==null)
			{
				resp.getWriter().print("<h1 style='color:red'>Session Expired,Login Again</h1>");
				req.getRequestDispatcher("Login.html").include(req,resp);
			}
			else
			{
				int no=Integer.parseInt(req.getParameter("id"));
						UserDao dao= new UserDao();
				req.setAttribute("task", dao.fetchall());
				req.getRequestDispatcher("EditTask.jsp").forward(req, resp);
			}
		}

	}


