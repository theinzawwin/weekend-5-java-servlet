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
<h3>Grade List</h3>
<h4>${name }</h4>
<p>${phone }</p>
<b>${user}</b><br>
<c:forEach var="j" begin="1" end="3">  
   Item <c:out value="${j}"/><p>  
</c:forEach>  
</body>
</html>