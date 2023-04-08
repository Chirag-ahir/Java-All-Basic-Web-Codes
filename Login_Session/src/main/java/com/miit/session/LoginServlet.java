package com.miit.session;

//Here we used session object to get user's id and password and metching with hard coded values

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("user");
		String pass = req.getParameter("pass");

		if (pass.equals("1234")) {
			
			// creating a session
			HttpSession session = req.getSession();
			session.setAttribute("user", name);
			resp.sendRedirect("Welcome");
			
		} else {
			PrintWriter out = resp.getWriter();
			out.println("Either password or UserID is wrong!1");
			out.println("<br>");
			out.println("<a href='index.jsp'>Try again</a>");
		}
	}

}
