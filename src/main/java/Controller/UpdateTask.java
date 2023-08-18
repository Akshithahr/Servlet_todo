package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.MyUser;
import dto.Task;

@WebServlet("/updatetask")
public class UpdateTask extends HttpServlet {
	
	private MyUser user;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user")==null)
		{
			resp.getWriter().print("<h1 style='color:red'>Session Expired,Login Again</h1>");
			req.getRequestDispatcher("Login.html").include(req,resp);
		}
		else
		{
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String description=req.getParameter("description");
			int days=Integer.parseInt(req.getParameter("days"));
			
			Task task=new Task();
			task.setId(id);
			task.setName(name);
			task.setDescription(description);
			task.setTaskDate(LocalDate.now());
			task.setCompletionDate(LocalDate.now().plusDays(days));
			
			UserDao dao=new UserDao();
			dao.update(task);
			
			MyUser user2=dao.findByEmail(user.getEmail());
			req.getSession().setAttribute("users", user2);
			
		resp.getWriter().print("<h1> This is Updated task Servlet</h1>");
		req.setAttribute("list", user2.getTasks());
		req.getRequestDispatcher("Home.jsp").include(req,resp);
	}

}
}
