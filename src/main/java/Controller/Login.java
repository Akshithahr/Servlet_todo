package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.MyUser;
@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   String password=req.getParameter("password");
			String email=req.getParameter("email");
			
UserDao userdao=new UserDao();

MyUser myuser=userdao.findByEmail(email);
if(myuser==null){
	
 resp.getWriter().print("<h1 style='color:blue>incorrect email</h1>");
 req.getRequestDispatcher("login.html").include(req, resp);
}
else{
    if(myuser.getPwd().equals(password))
    {
    	req.getSession().setAttribute("user", myuser);
    	req.getSession().setMaxInactiveInterval(60);
    	resp.getWriter().print("<h1>Login success</h1>");
    	
    	req.setAttribute("list",myuser.getTasks()); 
    	 req.getRequestDispatcher("Home.jsp").include(req, resp);
    }
    
    	else{
        	resp.getWriter().print("<h1>incorrect password</h1>");
        	 req.getRequestDispatcher("login.html").include(req, resp);


    }

}

	}
}

