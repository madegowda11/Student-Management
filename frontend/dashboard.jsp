<%@page import="com.dcl.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="dashboard.css">
<style>
table tr , table th{
padding:20px 20px;
}
</style>
</head>
<body>
<%if(request.getAttribute("success")!=null){ %>
<%=request.getAttribute("success")%>
<%} %>
<% Student s=(Student) session.getAttribute("student");
%>
<nav>
<div>
<a>Welcome</a>
</div>
<ul>
<li><a href="#">View all students</a></li>
<li><a href="update.jsp">Update</a></li>
<li><a href="#">Profile view</a></li>

</ul>
<form action="logout" method="get">
<button>Logout</button>
</form>
<form action="#">
<table>
<tr><th>SID</th>
<th>NAME</th>
<th>PHONE</th>
<th>EMAIL</th>
<th>BRANCH</th>
<th>LOCATION</th>
</tr>

<tr>
<td><%=s.getSid() %></td>
<td><%=s.getSname() %></td>
<td><%=s.getPhone() %></td>
<td><%=s.getEmail() %></td>
<td><%=s.getBranch() %></td>
<td><%=s.getLocation() %></td>
</tr>
</table>
</form>

</nav>
</body>
</html>
