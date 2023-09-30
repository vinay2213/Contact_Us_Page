package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactUs extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/ContactUs.jsp");
		rd.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String full_name = req.getParameter("name1");
		String e_mail = req.getParameter("email1");
		String message = req.getParameter("message");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_us_page", "root",
					"H@rdt0remember");

			PreparedStatement ps = con
					.prepareStatement("insert into contact_us_info(full_name, e_mail, message) values(?, ?, ?)");
			ps.setString(1, full_name);
			ps.setString(2, e_mail);
			ps.setString(3, message);

			int count = ps.executeUpdate();

			if (count > 0) {

				out.print("<h3 style='color:green'> Form submitted successfully. </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/ContactUs.jsp");
				rd.include(req, resp);
			} else {

				out.print("<h3 style='color:red'> Form is not submitted. Please try again. </h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/ContactUs.jsp");
				rd.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();

			out.print(e.getMessage());

			RequestDispatcher rd = req.getRequestDispatcher("/ContactUs.jsp");
			rd.include(req, resp);
		}
	}
}
