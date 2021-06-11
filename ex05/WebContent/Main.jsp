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
String id =(String) session.getAttribute("userId");
String name =(String) session.getAttribute("userName");

if(id == null){
	%>
	<script>
		alert('로그인을 해주세요');
	</script>
	<%
	response.sendRedirect("loginForm.jsp");
}else{
	%>
	<h3><%=name %>(<%=id %>)님 안녕하세요</h3>
	<form action="logout.jsp">
<input type="submit" value="로그아웃">
</form>
	<%	
}
%>


</body>
</html>