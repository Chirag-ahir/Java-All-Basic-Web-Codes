package com.miit.login;

//In this project we are doing Register and Login of students using JDBC only
//SQL Queries
//CREATE schema Register_Login;
//CREATE TABLE Register_Login.register_login (uname varchar(15), uemail varchar(35), upass varchar(15));

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miit.connection.GetConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("upass");

		try {
			PreparedStatement ps = GetConnection.getConnection().prepareStatement("select uname,upass from register_login where uemail=? and upass=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			// creating session here
			HttpSession session = request.getSession();
			session.setAttribute("email", email);

			if (rs.next()) {
				response.sendRedirect("welcome.jsp");
			} else {
				out.println("<font color=red size=18>Login failed!!!!<br>");
				out.println("<a href=index.html>Try again</a>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
