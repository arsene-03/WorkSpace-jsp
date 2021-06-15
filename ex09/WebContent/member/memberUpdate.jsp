<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h2>회원 정보 수정페이지</h2>
<form action="memberUpdate.do" method="POST" name="frm">
	<table>
		<tr>
			<td>이름</td>
			<td> <input type="text" name="name" size="20" value="${mVo.name}" readonly> </td>
		</tr>
		<tr>
			<td>아이디</td>
			<td> <input type="text" name="userId" size="20" value="${mVo.userId}" readonly> </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <input type="password" name="userPwd" size="20"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td> <input type="password" name="pwd_check" size="20"></td> 
		</tr>
		<tr>
			<td>이메일</td>
			<td> <input type="email" name="email" size="20" value="${mVo.email }"> </td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td> <input type="tel" name="phone" size="20" value="${mVo.phone}"> </td>
		</tr>
		<tr>
			<td>등급</td>
			<td>
				<c:choose>
					<c:when test="${mVo.admin ==0}">
						<input type="radio" name="admin" value="0" checked>일반회원
						<input type="radio" name="admin" value="1" >관리자
					</c:when>
					<c:when test="${mVo.admin ==1}">
						<input type="radio" name="admin" value="0" >일반회원
						<input type="radio" name="admin" value="1" checked>관리자
					</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="확인" onclick="return joinCheck()">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>