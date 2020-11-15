<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Grade</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h3>New Grade</h3>
<div>
	<form action="GradeServlet" method="post">
		<label>Name:</label><input type="text" name="name" /><br>
		<label>Teacher Name:</label><input type="text" name="teacherName" /><br>
		<input type="submit" value="Save" name="action" />
	</form>
</div>
</body>
</html>