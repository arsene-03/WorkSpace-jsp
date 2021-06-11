<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정밀 검사 페이지 입니다.</h1>
<form action="COVID(2)_Action_2.jsp">
발열 증상여부:  Y<input type="radio" name="fever" value="y">
N<input type="radio" name="fever" value="n"> <br>

호흡기 증상여부:  Y<input type="radio" name="respirator" value="y">
N<input type="radio" name="respirator" value="n"> <br>

2주내 해외 여행 여부:  Y<input type="radio" name="travel" value="y">
N<input type="radio" name="travel" value="n"> <br>

<input type="submit" value="확인">
</form>
</body>
</html>