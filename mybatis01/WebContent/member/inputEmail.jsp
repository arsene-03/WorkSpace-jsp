<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일로 데이터 조회</title>
</head>
<body>
<form action="${contextPath}/MSE" method="POST">
	이메일 : <input type="email" name="email">
	<input type="submit" value="조회">
</form>
</body>
</html>