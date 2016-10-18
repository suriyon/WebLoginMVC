<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<h3>Login</h3>
	<c:if test="${msg != null }">
		<p style="color: red;">${msg }</p>
	</c:if>
	<form action="LoginController" method="post">
		<table>
			<tr>
				<td>Username :</td>
				<td>
					<input type="text" name="username" placeholder="enter username"
					required="required">
				</td>
			</tr>
			<tr>
				<td>Password :</td>
				<td>
					<input type="password" name="password" placeholder="enter password"
					required="required">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>