<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="now" value="<%=new java.util.Date() %>"/>
	<fmt:formatDate value="${now }"/> <br>
	<fmt:formatDate value="${now }" type="time"/> <br>
	<fmt:formatDate value="${now }" type="both"/> <br>
	<fmt:formatDate value="${now }" pattern="yyyy년 mm월 dd일 hh시 mm분 ss초"/> <br>
	<fmt:timeZone value="GMT">
		GMT : <fmt:formatDate value="${now }" type="both"/> <br>
	</fmt:timeZone>
	
	<fmt:timeZone value="GMT-8">
		GMT-8 : <fmt:formatDate value="${now}" type="both"/> <br>
	</fmt:timeZone>
	
	<hr>
	
	톰켓서버의 기본 로케일 : <%=response.getLocale() %> <br>
	
	<fmt:setLocale value="ja_jp"/>
	로케일을 일본어로 설정한 후 로케일 확인: <%=response.getLocale() %> <br>
	통화: <fmt:formatNumber value="10000" type="currency"/> <br>
	날짜: <fmt:formatDate value="${now}" type="both"/> <br>
	
	<fmt:setLocale value="en_US"/>
	로케일을 미국어로 설정한 후 로케일 확인: <%=response.getLocale() %> <br>
	통화: <fmt:formatNumber value="10000" type="currency"/> <br>
	날짜: <fmt:formatDate value="${now}" type="both"/> <br>
	
	<fmt:setLocale value="ko_KR"/>
	로케일을 한국어로 설정한 후 로케일 확인: <%=response.getLocale() %> <br>
	통화: <fmt:formatNumber value="10000" type="currency"/> <br>
	날짜: <fmt:formatDate value="${now}" type="both"/> <br>
</body>
</html>