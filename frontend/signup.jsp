<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="signup.css">
</head>
<body>
<%if(request.getAttribute("success")!=null){ %>
 <p class="success"><%=request.getAttribute("success")%></p>
<%} %>
<%if(request.getAttribute("fail")!=null){ %>
 <p class="fail"><%=request.getAttribute("fail")%></p>
<%} %>
	<form action="signup" method="post">
		<input type="text" name="name" placeholder="Enter name">
		<input type="tel" name="phone" placeholder="Enter phone"> 
		<input type="email" name="email" placeholder="Ennter email"> 
		<input	type="text" name="branch" placeholder="Enter branch"> 
		<input	type="text" name="location" placeholder="Enter location"> 
		<input type="password" name="password" placeholder="Enter password">
		<input type="password" name="confirm" placeholder="confirm password">
		<input type="submit" value="signup"> 
		<a href="login.jsp">already have an account?</a>
	</form>
</body>
</html>
