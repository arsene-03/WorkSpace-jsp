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
pageContext.setAttribute("name", "페이지");
request.setAttribute("name", "리퀘스트");
session.setAttribute("name", "세션");
application.setAttribute("name", "어플리케이션");


%>
page 속성 : ${pagesScope.name} <br>
request 속성 : ${requestScope.name} <br>
session 속성 : ${sessionScope.name} <br>
application 속성 : ${applicationScope.name} <br>

<hr>
name 값 : ${name }

</body>
</html>