<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("id", "hong");
session.setAttribute("pwd", "green123");
session.setAttribute("name", "홍길동");

%>

<a href="./ex04_getSession.jsp">세션저장확인</a>
</body>
</html>