<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<%if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message") %>
<%} %>
<form action="submitforgotpassword" method="post">
Enter Email:<input type="email" name="email"/><br>
Enter Username: <input type="text" name="username"/><br>
<input type="submit" value="Create New Password"/>
</form>

<form action="submitnewpassword" method="post">
Enter new Password:<input type="password" name="password"/><br>
Re-Enter Password:<input type="password" name=""password2"/>
<%if(request.getAttribute("status")!=null) {%>
<input type="submit" value="Submit"/>
<% } %>
</form>
</body>
</html>