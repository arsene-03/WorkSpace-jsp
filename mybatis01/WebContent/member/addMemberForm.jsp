<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
</head>
<body>
<form action="${contextPath}/AM" method="POST">
	이메일: <input type="email" name="email"> <br>
	이름: <input type="text" name="name"> <br>
	비밀번호: <input type="password" name="password"> <br>
	<input type="submit" value="추가">
</form>
</body>
</html>