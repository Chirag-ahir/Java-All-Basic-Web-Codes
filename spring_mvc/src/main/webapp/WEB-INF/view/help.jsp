<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is help page</h1>
	<% 
		//Getting attribute value using DispatcherServlet
		String name = (String)request.getAttribute("name");
		Integer id = (Integer)request.getAttribute("id");
	%>
	
	<h2>Hello <%=name%> <%=id %></h2>

</body>
</html>