package in.sp.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateActive")
public class updateActive extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_us_page", "root",
					"H@rdt0remember");

			PreparedStatement ps = con.prepareStatement("update contact_us_info set status = 'archived' where id = ?");
			ps.setInt(1, Integer.parseInt(req.getParameter("id")));

			ps.executeUpdate();

			RequestDispatcher rd = req.getRequestDispatcher("/requests.jsp");
			rd.forward(req, resp);

		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

}
