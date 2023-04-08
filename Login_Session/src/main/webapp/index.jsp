<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Login Page</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	-webkit-font-smoothing: antialiased;
}

body {
	background: #e35869;
	font-family: 'Rubik', sans-serif;
}

.login-form {
	background: #fff;
	width: 500px;
	margin: 65px auto;
	display: -webkit-box;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	flex-direction: column;
	border-radius: 4px;
	box-shadow: 0 2px 25px rgba(0, 0, 0, 0.2);
}

.login-form h1 {
	padding: 35px 35px 0 35px;
	font-weight: 300;
}

.login-form .content {
	padding: 35px;
	text-align: center;
}

.login-form .input-field {
	padding: 12px 5px;
}

.login-form .input-field input {
	font-size: 16px;
	display: block;
	font-family: 'Rubik', sans-serif;
	width: 100%;
	padding: 10px 1px;
	border: 0;
	border-bottom: 1px solid #747474;
	outline: none;
	-webkit-transition: all .2s;
	transition: all .2s;
}

.login-form .input-field input::-webkit-input-placeholder {
	text-transform: uppercase;
}

.login-form .input-field input:focus {
	border-color: #222;
}

.login-form a.link {
	text-decoration: none;
	color: #747474;
	letter-spacing: 0.2px;
	text-transform: uppercase;
	display: inline-block;
	margin-top: 20px;
}

.login-form .action {
	display: -webkit-box;
	display: flex;
	-webkit-box-orient: horizontal;
	-webkit-box-direction: normal;
	flex-direction: row;
}

.login-form .action {
	width: 100%;
	padding: 18px;
	cursor: pointer;
	background: #e8e9ec;
	border-bottom-left-radius: 4px;
	border-bottom-right-radius: 0;
	-webkit-transition: all .3s;
}

.login-form .action .btn {
	border: none;
	outline: none;
	font-family: 'Rubik', sans-serif;
	color: #777;
	font-size: 16px;
	background: transparent;
	align: center;
	text-transform: uppercase;
	margin: auto;
	pointer: cursor;
}
</style>

</head>
<body>

	<div class="login-form">
		<form action="login" method="post">
		
			<h1>Login</h1>
			<div class="content">
				<div class="input-field">
					<input type="text" placeholder="UserID" autocomplete="nope"
						name="user">
				</div>
				<div class="input-field">
					<input type="password" placeholder="Password"
						autocomplete="new-password" name="pass">
				</div>
			</div>
			<div class="action">
				<input class="btn" type="submit" value="submit" />
			</div>
			
		</form>
	</div>
	
</body>
</html>