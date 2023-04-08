package com.miit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession();
		out.println("Hello " + (String) session.getAttribute("user"));
		out.println("");
		out.println("Your servlet contex is: " + session.getServletContext());
		out.println("");
		out.println("Your session ID is: " + session.getId());

	}
}
