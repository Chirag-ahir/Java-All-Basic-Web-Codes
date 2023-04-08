package com.miit.register;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miit.connection.GetConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("upass");

		out.println("Welcome: " + uname);
		out.print("");
		out.println("We successfully record your data");
		out.print("");
		
		try {
			PreparedStatement ps = GetConnection.getConnection()
					.prepareStatement("insert into register_login(uname,uemail,upass) values(?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, email);
			ps.setString(3, password);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
