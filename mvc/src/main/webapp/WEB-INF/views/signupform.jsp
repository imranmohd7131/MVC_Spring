<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message=(String) request.getAttribute("message");
if(message!=null){
%>
<%=message %>
<% }%>
<form action="submitsignupform" method="post">
NName:
<input type="text" placeholder="Enter name" name="username">
<br>
Email:
<input type="email" placeholder="Enter email" name="email">
<br>
Password:
<input type="password" placeholder="Enter password" name="password">
<br>
<input type="submit" value="Submit">
</form>
</body>
</html>