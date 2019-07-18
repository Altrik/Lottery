<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="/signin" method="post">
	<label>Login
		<input type="text" name="login">
	</label>
	<br>
	<label>Password
		<input type="password" name="password">
	</label>
	<br>
	<input type="submit" name="requestLogIn" value="Log In">
</form>
</div>
</body>
</html>