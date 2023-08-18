package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.MyUser;
import dto.Task;

@WebServlet("/changestatus")

public class ChangeStatus  extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	MyUser myUser=(MyUser)req.getSession().getAttribute("myUse");	
	 if(myUser==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session Expired,Login Again</h1>");
			req.getRequestDispatcher("Login.html").include(req,resp);
		}
		else
		{
		int id=Integer.parseInt(req.getParameter("id"));
		UserDao dao=new UserDao();
		Task task=dao.fetchTask(id);
		if(task.isStatus())
			task.setStatus(false);
		else
			task.setStatus(true);
		
		dao.update(task);
		
		MyUser myUser1=dao.findByEmail(myUser.getEmail());
		req.getSession().setAttribute("myUser", myUser1);
		resp.getWriter().print("<h1 style='color:green'>Status Changed Success</h1>");
		req.setAttribute("list", myUser.getTasks());
	    req.getRequestDispatcher("Home.jsp").include(req, resp);

		}
		}
	 
	 
	
}