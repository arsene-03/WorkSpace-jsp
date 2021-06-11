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
request.setCharacterEncoding("UTF-8");
session.setAttribute("name", request.getParameter("userName"));
session.setAttribute("bodyTem", Double.parseDouble(request.getParameter("bodyTem")));

if(session.getAttribute("name")==null){
	response.sendRedirect("COVID(2)_19.jsp");
}else if((double)session.getAttribute("bodyTem")<=37.5){
	response.sendRedirect("COVID(2)_19_negative.jsp"); //음성자
}else {
	response.sendRedirect("COVID(2)_Chk.jsp");
}

%>
</body>
</html>