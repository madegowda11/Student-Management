<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
<%if(request.getAttribute("failed")!=null){ %>
<p class="failed"><%=request.getAttribute("failed")%></p>
<%} %>
<%if(request.getAttribute("successfull")!=null){ %>
<p class="successfull"><%=request.getAttribute("successfull")%></p>
<%} %>
<form action="login" method="post">
<input type="text" name="phone" placeholder="Enter phone">
<input type="password" name="password" placeholder="Enter password">
<input type="submit" value="login">
<a href="signup.jsp">don't have account</a>
<a href="forgotpassword.jsp">Forgot Password?</a>
</form>
</body>
</html>
