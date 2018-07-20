<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	$(function() {
		/*  Submit form using Ajax */
		$('button[id=submitJson]').click(function(e) {
			//Prevent default submission of form
			e.preventDefault();
			$.post({
				url : '${pageContext.request.contextPath}/getAjaxJson',
				data : $("#ajaxFormJson").serialize(),
				success : function(res) {
					if (res.validated) {
						console.log(res);
						alert("success !");
					} else {
						//Set error messages
						$.each(res.errorMessages, function(key, value) {
							$('input[name=' + key + ']').after(
									'<span class="error">' + value
											+ '</span>');
						});
					}
				}
			})
		});
		
		$('button[id=submitHtml]').click(function(e) {
			//Prevent default submission of form
			e.preventDefault();
			$.post({
				url : '${pageContext.request.contextPath}/getAjaxHtml',
				data : $("#ajaxFormHtml").serialize(),
				success : function(res) {
					$("#html-result").html(res);
				}
			})
		});
	});
</script>
<title>Spring Boot</title>
</head>
<body>
	<h1>Spring Boot - MVC web application example</h1>
	<hr>

	<h2>Your name is ${customerDTO.name}</h2>
	<h2>Your email is ${customerDTO.email}</h2>
	<h2>Your birthDay is ${customerDTO.birthDay}</h2>
	<c:forEach items="${customerDTO.listAddress}" var="address"
		varStatus="status">
		<h4>Address ${status.index} : ${address.name}</h4>
	</c:forEach>
	<form action="${pageContext.request.contextPath}/getAjaxJson"
		method="POST" id="ajaxFormJson" name="ajaxDTO">
		<input name="customerName" />
		<button type="submit" id="submitJson">Get Ajax Json</button>
	</form>

	<form action="${pageContext.request.contextPath}/getAjaxHtml"
		method="POST" id="ajaxFormHtml" name="ajaxDTO">
		<input name="customerName" />
		<button type="submit" id="submitHtml">Get Ajax Html</button>
	</form>
	
	<h2>Div ajax html</h2>
	<div id="html-result"></div>
</body>
</html>
