<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout page</title>

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

	<div class="center">
		<h1>Logout successfully!!</h1>
		<%
		session.invalidate();
		%>
		<a href="index.html">Home</a>
	</div>

</body>
</html>