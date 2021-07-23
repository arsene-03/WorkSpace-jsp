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
<a href="<c:url value="http://localhost:8090/mybatis01/FS"/>">[회원 목록 조회]</a>
<a href="<c:url value="http://localhost:8090/mybatis01/SS"/>">[회원 목록 조회 - HashMap]</a>
<a href="<c:url value="http://localhost:8090/mybatis01/MC"/>">[회원 수 조회]</a>
<a href="<c:url value="http://localhost:8090/mybatis01/MSE"/>">[회원 이메일로 조회]</a><br>
<a href="<c:url value="http://localhost:8090/mybatis01/AM"/>">[회원 추가]</a>
<a href="<c:url value="http://localhost:8090/mybatis01/UM"/>">[회원 수정]</a>
<a href="<c:url value="http://localhost:8090/mybatis01/DM"/>">[회원 삭제]</a><br>
<br>
<a href="<c:url value="http://localhost:8090/mybatis01/SM"/>">[회원 목록 조회]</a>
<a href="<c:url value="http://localhost:8090/mybatis01/FSM"/>">[회원 이름 조회]</a>


</body>
</html>