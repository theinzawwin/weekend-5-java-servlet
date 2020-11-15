<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h3>Grade List</h3>
<table>
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Teacher Name</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${gradeList }" var="g" varStatus="row">  
    	<td>${row.count }</td>
    	<td>${g.name }</td>
    	<td>${g.teacherName }</td>
</c:forEach>  
	</tbody>
</table>

</body>
</html>