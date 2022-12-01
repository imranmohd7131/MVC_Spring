<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightgreen"><center>
<% if(request.getAttribute("message")!=null) { %>
<h2 style="color:red";>
<%= request.getAttribute("message")%></h2>
<% } %><br> <pre>
<form action="submitloginform" method="post"> 
Enter Email    : <input type="email" placeholder="Enter email" name="email"><br>
Enter Password : <input type="password" placeholder="Enter password" name="pswd"><br>
<input type="submit" value="Login">
</form></pre></center>
<a href="forgotpassword">Forgot Password</a>
</body>
</html>