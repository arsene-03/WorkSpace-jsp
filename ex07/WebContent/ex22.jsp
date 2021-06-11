<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>POST에서 한글 깨짐 현상</h3>
<form action="ex22_encoding1.jsp" method="POST">
	이름: <input type="text" name="name">
	<input type="submit" value="전송">
</form>

<h3>POST에서 한글 깨짐 방지1</h3>
<form action="ex22_encoding2.jsp" method="POST">
	이름: <input type="text" name="name">
	<input type="submit" value="전송">
</form>

<h3>POST에서 한글 깨짐 방지-포맷을 활용한 방법</h3>
<form action="ex22_encoding3.jsp" method="POST">
	이름: <input type="text" name="name">
	<input type="submit" value="전송">
</form>
</body>
</html>