package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.collections.List;
import dao.UserDao;
import dto.MyUser;
import dto.Task;
@WebServlet("/addtask")
public class AddTask extends HttpServlet {
	
@Override
protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if(req.getSession().getAttribute("user")==null)
	{
		resp.getWriter().print("<h1 style='color:red'>Session Expired,Login Again</h1>");
		req.getRequestDispatcher("Login.html").include(req,resp);
	}
	else
	{
	
	
	String Name=req.getParameter("name");
	String description=req.getParameter("description");
	int days=Integer.parseInt(req.getParameter("days"));
	
	Task t=new Task();
	
	t.setName(Name);
	t.setDescription(description);
	t.setTaskDate(LocalDate.now());
	t.setCompletionDate(LocalDate.now().plusDays(days));
	
	MyUser myUser=(MyUser)req.getSession().getAttribute("user");
	java.util.List<Task> list=myUser.getTasks();
			if(list==null)
				list=new ArrayList<Task>();
			list.add(t);
			myUser.setTasks(list);
			
			UserDao dao=new UserDao();
			dao.save(t);
			dao.update (myUser);
			
			MyUser myUser1=dao.findByEmail(myUser.getEmail());
			req.getSession().setAttribute("myUser", myUser1);
				
	resp.getWriter().print("<h1 style='color:blue'>Task added Successfully</h1>");
	req.setAttribute("list", myUser.getTasks());
    req.getRequestDispatcher("Home.jsp").include(req, resp);


}
}
}
