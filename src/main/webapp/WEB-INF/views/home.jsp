<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot</title>
</head>
<body>
	<h1>Spring Boot - MVC web application example</h1>
	<hr>

	<div class="form">
		<spring:form action="submit" method="POST"
			modelAttribute="customerDTO">
			<table>
				<tr>
					<td>Enter Your name</td>
					<td><spring:input path="name" /></td>
					<td><spring:errors path="name" /></td>
				</tr>
				<tr>
					<td>Enter Your email</td>
					<td><spring:input path="email" /></td>
					<td><spring:errors path="email" /></td>
				</tr>
				<tr>
					<td>Enter Your birthDay</td>
					<td><spring:input path="birthDay" /></td>
					<td><spring:errors path="birthDay" /></td>
				</tr>
				<c:forEach items="${customerDTO.listAddress}" var="address" varStatus="status">
				<tr>
					<td>Address ${status.index + 1}</td>
					<td><spring:input path="listAddress[${status.index}].name" /></td>
					<td><spring:errors path="listAddress[${status.index}].name" /></td>
				</tr>
				</c:forEach>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</spring:form>
	</div>

</body>
</html>