<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 생성</h3>
<%
// 1. 쿠키 객체를 생성해 봅시다
Cookie c = new Cookie ("id","hong");

//2. 유효시간 설정
c.setMaxAge(60*60*24*365);//1년

//3. 클라이언트에 쿠기 객체 전송
response.addCookie(c);

response.addCookie(new Cookie("pwd","green1234"));
response.addCookie(new Cookie("name","홍길동"));

response.addCookie(new Cookie("id","choi")); // 기존 데이터 갱신
%>
</body>
</html>