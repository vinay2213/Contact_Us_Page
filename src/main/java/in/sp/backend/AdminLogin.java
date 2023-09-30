package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/login")
public class AdminLogin extends HttpServlet{
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/AdminLogin.jsp");
		rd.forward(req, resp);
		}
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter out = resp.getWriter();
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	if(email.equals("vinaygoyal0460@gmail.com") && password.equals("H@rdt0remember")) {
		
		resp.sendRedirect("/Contact_Us_Page/admin/contactus/requests");
		
	}
	else
	{
		out.print("Invalid credentials");
	}
}


}
