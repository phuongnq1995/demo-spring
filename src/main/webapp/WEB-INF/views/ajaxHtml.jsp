<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>List of customer</h3>
<table>
	<c:forEach items="${list}" var="per">
		<tr>
			<td>Enter Your name: ${per.name}</td>
			<td>Enter Your email: ${per.email}</td>
			<td>Enter Your email: ${per.birthDay}</td>
		</tr>
	</c:forEach>
</table>
