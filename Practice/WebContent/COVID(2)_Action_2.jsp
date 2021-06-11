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
	session.setAttribute("fever", request.getParameter("fever"));
	session.setAttribute("respirator", request.getParameter("respirator"));
	session.setAttribute("travel", request.getParameter("travel"));
	if(session.getAttribute("fever")==null){
		response.sendRedirect("COVID(2)_Chk.jsp");
	}else if(session.getAttribute("fever")=="n"
			&&session.getAttribute("respirator")=="n"
			&&session.getAttribute("travel")=="n"){
		response.sendRedirect("COVID(2)_19_negative.jsp"); //음성자
	}else{
		int random = (int)(Math.random()*100);
		%>
		<%=random %>
		<%
		if(random%2==1){
			response.sendRedirect("COVID(2)_19_negative.jsp"); //음성자	
		}else{
			response.sendRedirect("COVID(2)_19_positive.jsp"); //양성자
		}
	}
%>
</body>
</html>