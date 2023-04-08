package com.miit.login;
//This project demonstrate how we can fetch user input data in our class using getParameter method of req and how we can run SQL query using prepare statement.
//SQL Queries
//CREATE schema Login_MySQL;
//CREATE TABLE Login_MySQL.login (user_id varchar(10), password varchar(15));
//INSERT INTO Login_MySQL.login VALUES("cahir001","1234");
//We have used pure JDBC here

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class login_page extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login_MySQL", "root", "Prin@2014");

			String userid = req.getParameter("user_id");
			String pass = req.getParameter("password");

			PreparedStatement ps = con.prepareStatement("select user_id from login where user_id=? and password=?");
			ps.setString(1, userid);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps1 = con.prepareStatement("select * from login");
			ps1.execute();

			if (rs.next()) {
				res.sendRedirect("welcome.jsp");
			} else {
				out.println("<font color=red size=18>Login failed!!!!<br>");
				out.println("<a href=index.jsp>Try again</a>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
