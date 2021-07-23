<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회</title>
</head>
<body>
<form action="${contextPath}/SM" method="POST">
	검색하고 싶은 이메일 : <input type="email" name="email"><br>
	검색하고 싶은 이름 : <input type="text" name="name"><br>
	<input type="submit" value="조회">
</form>
</body>
</html>