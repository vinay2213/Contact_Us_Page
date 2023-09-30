<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Requests</title>

</head>
<body>
	
	<table>

		<tr>
			<th>ID</th>
			<th>Full Name</th>
			<th>E-mail</th>
			<th>Message</th>
			<th>Status</th>
		</tr>

		<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_us_page", "root",
			"H@rdt0remember");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from contact_us_info");

			while (rs.next()) {
				int id = rs.getInt(4);
				String full_name = rs.getString(1);
				String e_mail = rs.getString(2);
				String message = rs.getString(3);
				String status = rs.getString(5);
				if (status.equals("active")) {
		%>

		<tr>
			<td><%=id%></td>
			<td><%=full_name%></td>
			<td><%=e_mail%></td>
			<td><%=message%></td>
			<td><a
				href="${pageContext.request.contextPath}/updateActive?id=<%=id%>"><button>
						<%=status%>
					</button> </a>
			<td>
		</tr>


		<%
		}
		}
		%>
	</table>
	
	
	
	<table>
		<tr>
			<th>ID</th>
			<th>Full Name</th>
			<th>E-mail</th>
			<th>Message</th>
			<th>Status</th>
		</tr>

		<%
		ResultSet rs2 = st.executeQuery("select * from contact_us_info");

		while (rs2.next()) {
			int id = rs2.getInt(4);
			String full_name = rs2.getString(1);
			String e_mail = rs2.getString(2);
			String message = rs2.getString(3);
			String status = rs2.getString(5);
			if (status.equals("archived")) {
		%>

		<tr>
			<td><%=id%></td>
			<td><%=full_name%></td>
			<td><%=e_mail%></td>
			<td><%=message%></td>
			<td><a
				href="${pageContext.request.contextPath}/updateArchive?id=<%=id%>"><button>
						<%=status%>
					</button> </a>
			<td>
		</tr>


		<%
		}
		}

		}

		catch (Exception e) {
		e.printStackTrace();
		}
		%>

	</table>
	
</body>
</html>