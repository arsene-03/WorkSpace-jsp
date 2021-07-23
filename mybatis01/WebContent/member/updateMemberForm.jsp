<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<form action="${contextPath}/UM" method="POST">
	조회할 이메일 : <input type="email" name="email"><br>
	변경할 이름 : <input type="text" name="name"><br>
	변경할 비밀번호 : <input type="password" name="password"><br>
	<input type="submit" value="변경">
</form>
</body>
</html>