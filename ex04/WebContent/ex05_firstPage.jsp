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
	pageContext.setAttribute("name", "page data");
	request.setAttribute("name", "request data");
	session.setAttribute("name", "session data");
	application.setAttribute("name", "application data");
	
	System.out.println("ex05_firstPage.jsp");
	System.out.println("하나의 페이지 속성: "+pageContext.getAttribute("name"));
	System.out.println("하나의 요청 속성: "+request.getAttribute("name"));
	System.out.println("하나의 세션 속성: "+session.getAttribute("name"));
	System.out.println("하나의 애플리케이션 속성: "+application.getAttribute("name"));
	
	request.getRequestDispatcher("ex05_secondPage.jsp").forward(request, response);
%>
</body>
</html>