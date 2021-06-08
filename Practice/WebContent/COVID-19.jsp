<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Covid.jsp" method="POST">
		이름: <input type="text" name="userName"> <br>
		체온: <input type="number" name="bodyTem" step="0.1"> <br>
		<input type="submit" value="결과 확인">
	</form>
</body>
</html>