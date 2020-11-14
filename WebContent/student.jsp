<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Student List</h3>
<table>
	<thead>
	<tr>
		<th>No</th>
		<th>Name</th>
		<th>Roll No</th>
		<th>Nrc</th>
	</tr>
	</thead>
	<tbody>
	
		<c:forEach items="${studentList}" var="std" varStatus="row">
		<tr>
		<td>${std.id}</td>
			<td>${std.name }</td>
			<td>${std.rollNo }</td>
			<td>${std.nrc }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>