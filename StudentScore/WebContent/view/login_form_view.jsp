<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<link type="text/css" rel="stylesheet" href="css/score.css">
</head>
<body>
	<div id="wrap">
		<section id="middle">
			<div id="loginform">
			<form action="SS" method="POST">
				<input type="hidden" name="command" value="login_action">
				<table>
					<tr>
						<th colspan="2">학생성적관리 프로그램</th>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPwd"></td>
					</tr>
					<tr>
					<td colspan="2" id="but">
						<input type="submit" value="로그인">
						<input type="button" value="회원가입" onclick="location.href='SS?command=signup_form_action'">
					</td>
					</tr>
				</table>
			</form>
			</div>
		</section>
	</div>
</body>
</html>