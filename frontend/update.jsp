<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<input type="number" name="sid" placeholder="Enter Student ID" required>
<input type="text" name="name" placeholder="Enter name">
<input type="email" name="email" placeholder="Enter email">
<input type="text" name="branch" placeholder="Enter branch">
<input type="text" name="location" placeholder="Enter location">
<input type="submit" value="Update">
<a href="dashboard.jsp">Back</a>
</form>
</body>
</html>
