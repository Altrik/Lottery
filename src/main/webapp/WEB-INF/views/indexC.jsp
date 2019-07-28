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
<p>Hello World!</p>
<br>
<div>
<form action=<c:url value="/signin"/> method="post">
	<label>Login
		<input type="text" name="login">
	</label>
	<br>
	<label>Password
		<input type="password" name="password">
	</label>
	<br>
	<input type="submit" name="requestLogIn" value="LogIn">
</form>
</div>
<br>
</body>
</body>
</html>