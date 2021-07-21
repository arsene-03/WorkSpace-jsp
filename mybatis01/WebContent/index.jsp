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
<a href="<c:url value="http://localhost:8090/mybatis01/MSE"/>">[회원 이메일로 조회]</a>

</body>
</html>