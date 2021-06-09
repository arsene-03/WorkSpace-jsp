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
	String userName = request.getParameter("userName");
	String jender = request.getParameter("jender");
	String[] season = request.getParameterValues("season");
	%>
	<h1>이름: <%=userName%></h1>
	
	<%
	if(jender=="male"){
	%>	
		<h1>성별: 남성</h1>
	<% 
	}else{
	%>
		<h1>성별: 여성</h1>
	<%	
	}
	%>	
	당신이 좋아하는계절: <br>
	<%
	for(int i=0;i<season.length;i++){
		switch(season[i]){
		case "spring" : out.println("봄입니다.<br>");
			break;
		case "summer" : out.println("여름입니다.<br>");
			break;
		case "autumn" : out.println("가을입니다.<br>");
			break;
		case "winter" : out.println("겨울입니다.<br>");
			break;
		}
	}
	%>
</body>
</html>