<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<p>Sign In</p>
<br>
<div>
<form action=<c:url value="/signin"/> method="post">
	<label>Login
		<input type="text" name="login" required>
	</label>
	<br>
	<label>Password
		<input type="password" name="password" required>
	</label>
	<br>
	<input type="submit" name="requestLogIn" value="LogIn">
</form>
</div>
<br>
<p>Register<p/>
<div>
<form action=<c:url value="/signup"/> method="post">
	<label>Login
		<input type="text" name="login" required>
	</label>
	<br>
	<label>Password
		<input type="password" name="password" required>
	</label>
	<br>
	<label>Email
		<input type="email" name="email" required>
	</label>
	<br>
	<input type="submit" name="requestSignUp" value="SignUp">
</form>
</div>
<br>
</body>
</body>
</html>