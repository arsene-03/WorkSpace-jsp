<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] admin = {"admin","1234"};
	String[] user = {"green","5678"};
	
	String userId = request.getParameter("userId");
	String userPW = request.getParameter("userPW");
	
	if(admin[0].equals(userId)&&admin[1].equals(userPW)){//관리자
%>
<jsp:forward page="ex07_adminMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("관리자","UTF-8") %>' name="name"/>
</jsp:forward>
<%
	}else if(user[0].equals(userId)&&user[1].equals(userPW)){
		%>
<jsp:forward page="ex07_userMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("고객","UTF-8") %>' name="name"/>
</jsp:forward>
<%				
	}else{
%>
<script>
	alert('로그인 실패 : 아이디 또는 비밀번호가 틀립니다.');
	history.go(-1);
</script>
<%
}
	
%>