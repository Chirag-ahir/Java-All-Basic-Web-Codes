<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Try to Login in your profile</h2>
	
	<form action="validate" method="post">
		Username <input type="text" name="username" />
		Password <input type="password" name="password">
		<input type="submit" value="login"/>
	</form><br>
	<span style="color:red">${errorMessage}</span><br/>
	
</body>
</html>