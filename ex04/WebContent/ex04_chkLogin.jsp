
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String savedId = "green";
	String savedPW = "1234";
	String savedName = "최서희";
	
	request.setAttribute("name", savedName);
	String userId = request.getParameter("userId");
	String userPW = request.getParameter("userPW");
	
	if(userId.equals(savedId)&& userPW.equals(savedPW)){
		//response.sendRedirect("ex04_main.jsp?savedName="+URLEncoder.encode(savedName,"UTF-8")); //다이렉트방식
		RequestDispatcher a = request.getRequestDispatcher("ex04_main.jsp"); //포워드 방식
		a.forward(request, response);
	}else{
		response.sendRedirect("ex04_loginFail.jsp");
	}
%>
</body>
</html>