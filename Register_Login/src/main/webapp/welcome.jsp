
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>

<style>
.center {
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

a {
	padding: 10px;
	text-decoration: none;
	color: white;
	background-color: blue;
	border-radius: 5px;
}
</style>

</head>
<body>

	<%
	response.setHeader("Cache-control", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expire", 0);

	//getting value of session
	String email = (String) session.getAttribute("email");
	if (email == null) {
		response.sendRedirect("LogoutServlet.jsp");
	}
	%>

	<div class="center">
		<h1>
			Login Successful! welcome
			<%
		out.println(email);
		%>
		</h1>
		<a href="LogoutServlet.jsp">Click here to logout</a>
	</div>

</body>
</html>