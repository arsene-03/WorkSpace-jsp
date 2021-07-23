<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
</head>
<body>
<form action="${contextPath}/DM" method="POST">
	삭제할 이메일 : <input type="email" name="email"><br>
	<input type="submit" value="삭제">
</form>
</body>
</html>