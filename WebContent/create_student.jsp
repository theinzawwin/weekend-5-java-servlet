<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h3>Manage Student</h3>
<form action="StudentServlet" method="post">
<label>Name:</label><input type="text" name="name" /><br>
<label>Nrc:</label><input type="text" name="nrc" /><br>
<label>Phone No:</label><input type="text" name="phone" ><br>
<label>Address:</label><input type="text" name="address" ><br>
<input type="submit" value="Save" />
</form>
</body>
</html>