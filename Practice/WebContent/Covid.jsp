<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int random = (int)(Math.random()*100);

%>
<%
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("userName");
	String bodyTem = request.getParameter("bodyTem");
	double userTem = Double.parseDouble(bodyTem);
	System.out.println(random);
	if(userTem<37.5){
%>
		<h1><%=userName %>님 코로나 '음성'입니다.</h1>
<% 				
	}else if(random<=19){
%>	
		
		<h1><%=userName %>님 코로나 '양성'입니다.</h1>
<%
	}else{
%>
		<h1><%=userName %>님 코로나 '음성'입니다.</h1>
<%		
	}
%>
	
</body>
</html>