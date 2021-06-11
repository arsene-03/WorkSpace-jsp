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
<c:set var="msg" value="Hello" scope="request"/>
<%
	request.setAttribute("msg", "hello");
%>
표현식 표기법 <br>
<%=(String)request.getAttribute("msg") %>

<hr>
EL표기법<br>
${msg}<br>

jstl 표기법 <br>
<c:out value="${msg}"/> <br>

<c:set var ="add" value="${10+20}"/>
합계: ${add} <br>;
<c:set var="bool" value="${10>20}"/> 
10>20: ${bool}<br>

<hr>
<c:set var ="member" value="<%= new com.green.beans.Member() %>"/>
<c:set target="${member}" property="userName" value="세종"/> 
<c:set target="${member}" property="userId">
	King
</c:set>
<br>
이름: ${member.userName }<br>
아이디: ${member["userId"]}<br>

<c:set var="test" value="테스트"/>
변수 선언 후 테스트 값: ${test} <br>
<c:remove var="test"/>
변수 삭제 후 테스트 값: ${test} <br>

</body>
</html>