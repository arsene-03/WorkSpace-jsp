<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Member m1 = new Member(); // 임포트 해주기
m1.setName("고길동");
m1.setUserId("ko");

session.setAttribute("member1", m1);

//(Member)session.getAttribute("member1");

Member m2 = new Member();



%>
이름: <%=m1.getName() %> <br>
아이디: <%=m1.getUserId()%> <br>

<jsp:useBean class="com.green.beans.Member"
				id="m3"
				scope="session"/><%// =com.green.beans.Member m3 = new com.green.beans.Member();
									// session.setAttribute("m4",m4)%>				
</body>
</html>