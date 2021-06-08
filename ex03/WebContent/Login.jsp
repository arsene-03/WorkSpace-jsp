<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String stoerdId = "green";
	String stoerdPW = "1234";
%>
	<%
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("usersPassword");
	
	if(userid.equals(stoerdId)&& userpw.equals(stoerdPW)){
	%>
		<h1><%=userid %>님 로그인 성공 하셨습니다.</h1>
	<%
	}else{
	%>			
		<h1>아이디 또는 비밀번호가 틀렸습니다.</h1>
	<%
	}
	%>
</body>
</html>