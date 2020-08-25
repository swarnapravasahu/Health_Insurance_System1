<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${errMsg}
<table>

<form:form action="registation"  method="POST" modelAttribute="register">

<tr>

<td><form:hidden path="registId" /></td>
</tr>

<tr>
<td>First Name :</td>
<td><form:input path="fsName" /></td>
</tr>
<tr><td>Last Name :</td>
<td><form:input path="lsName" /></td>
</tr>
<tr>
<td>Email :</td>
<td><form:input path="emailId" /></td>
</tr>
<tr>


<tr>
<td>Gender :</td>
<td><form:radiobutton value="M" path="gender" />Male 
<form:radiobutton value="F" path="gender" />Female </td>
</tr>

<tr>
<td>Role :</td>
<td><form:select path="role">
 <form:option value="">-Select-</form:option>
<form:options items="${roleMap}"/>
</form:select>
</td>
</tr>

<tr>
<td><input type="submit" value="SUBMIT"></td>
<td><input type="reset" value="RESET"></td>
</tr>
</form:form>
</table>
</body>
</html>