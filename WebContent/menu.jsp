<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style>
     ul{
    	list-style-type:none;
    	display: inline-block;
    }
    li{
    	display: inline;
    	background-color: gray;
    	margin:10px;
    	padding:5px;
    }
    li a:hover{
    	color:read;
    }
    a{
    	text-decoration:none;
    }
    </style>
<ul>
<li>
		<a href="StudentServlet?action=list"> Student List</a>
	</li>
	<li>
		<a href="StudentServlet?action=new">New Student</a>
	</li>
	<li>
		<a href="GradeServlet?action=list"> Grade List</a>
	</li>
	<li>
		<a href="GradeServlet?action=new">New Grade</a>
	</li>
</ul>