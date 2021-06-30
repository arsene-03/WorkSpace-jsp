<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link type="text/css" rel="stylesheet" href="css/score.css">
</head>
<body>
	<div id="wrap">
		<%@include file="../include/header.jsp" %>
		<section>
			<div id="">
			<form action="SS" method="POST">
				<input type="hidden" name="command" value="signup_action">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPwd"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<th>반</th>
						<td><input type="text" name="userClass"></td>
					</tr>
					<tr>
						<th>유형</th>
						<td><input type="radio" name="type" value="student">학생</td>
						<td><input type="radio" name="type" value="teacher">교사</td>
					</tr>
					<tr>
						<td colspan="2" id="but">
							<input type="button" value="돌아가기" onclick="location.href='SS?command=login_form_action'">
							<input type="submit" value="회원가입">	
						</td>
					</tr>
				</table>
				<table >
					
				</table>
			</form>
			</div>
		</section>
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>