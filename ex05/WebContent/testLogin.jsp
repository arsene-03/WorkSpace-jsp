<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String id = "green";
String pwd = "1234";
String name = "그린";

String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");

if(id.equals(userId)&&pwd.equals(userPwd)){
	session.setAttribute("userId", userId);
	session.setAttribute("userName", name);
	response.sendRedirect("Main.jsp");
}else{
	%>
	<script>
		alert('로그인 실패 : 아이디 또는 비밀번호가 틀립니다.');
		history.go(-1);
	</script>
	<%
}


%>