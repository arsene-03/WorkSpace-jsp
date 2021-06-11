<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>입력된 값을 출력</h3>
1. request 객체를 활용한 방법
아이디 : <%=request.getParameter("userId") %><br>
비밀번호 : <%=request.getParameter("userPw") %><br>

<hr>

2. el표기법을 활용한 방법
아이디: ${param.userId} <br>
비밀번호: ${param["userPw"]}
</body>
</html>