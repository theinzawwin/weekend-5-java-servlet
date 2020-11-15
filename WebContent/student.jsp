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
<jsp:include page="menu.jsp"></jsp:include>
<h3>Student List</h3>
<label>${message}</label>
<table>
	<thead>
	<tr>
		<th>No</th>
		<th>Name</th>
		<th>Nrc</th>
		<th>Address</th>
		<th>Roll No</th>
	</tr>
	</thead>
	<tbody>
	
		<c:forEach items="${studentList}" var="std" varStatus="row">
		<tr>
		<td>${std.id}</td>
			<td>${std.name }</td>
			<td>${std.nrc }</td>
			<td>${std.address }</td>
			<td>${std.rollNo }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>