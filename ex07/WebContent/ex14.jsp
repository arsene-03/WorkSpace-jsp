<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String names = "최유리:안지훈:강청아:박정우:최학준:진서영";
	pageContext.setAttribute("names", names);
%>

<c:forTokens var= "name" items="${names }" delims=":;">
	${name} <br>
</c:forTokens>

	
</body>
</html>