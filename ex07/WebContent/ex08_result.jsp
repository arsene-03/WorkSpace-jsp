<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>리퀘스트에 저장된 자바빈 프로퍼티 꺼내보기</h3>
이름: ${member.userName} <br>
아이디: ${requestScope.member.userId}
</body>
</html>