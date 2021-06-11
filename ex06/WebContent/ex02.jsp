<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="com.green.beans.Member" id="m1" scope="session"/>

=> 데이터 저장하기 전<br>
이름: <%=m1.getName() %> <br>

=> 데이터 저장<br>
<%
m1.setName("홍길동");
%>
이름: <%=m1.getName() %> <br>
</body>
</html>