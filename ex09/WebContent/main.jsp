<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty loginUser}">
	<jsp:forward page="login.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전용 페이지</title>
</head>
<body>
<h2>회원 전용 패이지</h2>
<form action="logout.do" method="GET">
	<table>
		<tr>
			<td>
				안녕하세요. ${loginUser.name}(${loginUser.userId})님 환영합니다.
			</td>
		</tr>
		<tr>
		<td>
			<input type="submit" value="로그아웃">
			<input type="button" value="회원 정보 변경" onclick="location.href='memberUpdate.do?userId=${loginUser.userId}'">
		</td>
		</tr>
	</table>
</form>
</body>
</html>