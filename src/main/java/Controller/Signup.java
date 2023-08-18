package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import dao.UserDao;
import dto.MyUser;
import dto.Task;

@WebServlet("/Signup")

	
	public class Signup extends HttpServlet
	{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
        String name=req.getParameter("name");
		String email=req.getParameter("email");
		String number=req.getParameter("number");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String pwd=req.getParameter("password");
		String[] lang=req.getParameterValues("language");
		
		

//
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
//	EntityManager manager=factory.createEntityManager();	
//	    EntityTransaction transaction=manager.getTransaction();
		
		
		MyUser user=new MyUser();
		user.setAddress(address);
		user.setEmail(email);
		user.setPwd(pwd);
		user.setGender(gender);
		user.setLang(lang);
		user.setName(name);
		user.setMobile(Long.parseLong(number));
		user.setDob(LocalDate.parse(dob));
		
		UserDao userd=new UserDao();
		
		MyUser myUser=userd.findByEmail(email);
		if(myUser==null){
			
			userd.save(user);
			resp.setContentType("text/html");
			resp.getWriter().print("h1 style='color:Black'>Account created</h1>");
//			  resp.getWriter().print("h1 style='color:green'>Invalid Email</h1>");
		         req.getRequestDispatcher("Login.html").include(req, resp);
				}
//		else if(user.getPwd().equals(pwd)){
//		
//			req.getSession().setAttribute("user",myUser);
//         resp.getWriter().print("h1 style='color:green'>Login Successfully</h1>");
//         
//         List<Task>list=userd.fetchall();
//       req.setAttribute("list", userd.fetchall());
//         
//         req.getRequestDispatcher("Home.jsp").include(req, resp);
//		}
		else{
	         resp.getWriter().print("h1 style='color:red'>Email should not be repeated</h1>");
	         req.getRequestDispatcher("Signup.html").include(req, resp);

		}
//		
//		transaction.begin();
//		manager.persist(user);
//		transaction.commit();
		
	
		
		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
//		System.out.println(gender);
//		System.out.println(dob);
//		System.out.println(address);
//		System.out.println(pwd);
//		System.out.println(lang);
}
}
	
		
			

