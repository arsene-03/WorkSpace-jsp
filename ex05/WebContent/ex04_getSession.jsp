<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>세션에 저장된 값 읽어오기</h3>
<%
String id = (String)session.getAttribute("id"); //형변환을 시켜줘야함 Object -> String
String pwd = (String)session.getAttribute("pwd");
String name = (String)session.getAttribute("name");

%>

아이디: <%=id %> <br>
비밀번호: <%=pwd %><br>
이름: <%=name %><br>

<a href="./ex04_getSessionAll.jsp">세션에 저장된 모든 값 읽어오기</a>

</body>
</html>