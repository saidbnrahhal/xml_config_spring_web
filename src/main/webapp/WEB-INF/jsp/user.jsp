<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form commandName="user">
		<table>
			<tr>
				<td>user name :</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>password :</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="validate" /></td>
			</tr>
		</table>
	</form:form>
  list of all users
  <c:if test="${not empty users}"> 
   <table>
		<tr>
			<td>id<td>
			<td>first name</td>
			<td>last name</td>
			<td>email</td>
			<td>password</td>
		</tr>
	<c:forEach var="item" items="${users}">
		<tr>
			<td>${item.id}<td>
			<td>${item.firstName}</td>
			<td>${item.lastName}</td>
			<td>${item.email}</td>
			<td>${item.password}</td>
		</tr>
	</c:forEach>
   </table>	
</c:if>
</body>
</html>