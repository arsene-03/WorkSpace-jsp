<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>비밀번호</th>
		<th>가입일</th>
	</tr>
	<c:forEach var="m" items="${lists}">
		<tr>
			<td>${m.id}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
			<td>${m.password}</td>
			<td>${m.regdate}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>