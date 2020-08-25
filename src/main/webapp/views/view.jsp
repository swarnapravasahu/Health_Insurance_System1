<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Admin List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Registartion Id</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Role</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="admin" items="${list}">   
   <tr>  
   <td>${admin.registId}</td>  
   <td>${admin.fsName}</td>  
    <td>${admin.lsName}</td>  
   <td>${admin.gender}</td>  
   <td>${admin.role}</td>  
   <td><a href="/register/${admin.registId}">Edit</a></td>  
   <td><a href="deleteadmin/${admin.registId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/register">Add New Details</a>  


</body>
</html>