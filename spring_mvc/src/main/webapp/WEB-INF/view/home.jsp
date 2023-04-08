<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>

	<% 
		//Getting attribute value using DispatcherServlet
		String name = (String)request.getAttribute("name");
		Integer no = (Integer)request.getAttribute("roll no");
	%>

	<h2>Hello <%=name%> <%=no %></h2>
	<p>This is your Home Page</p>
	<a href="https://youtu.be/hiks4tGZOpE" target="_blank">Refer Video to learn about Model</a>

</body>
</html>