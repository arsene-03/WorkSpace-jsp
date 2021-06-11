<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
정수타입: ${30} <br>
실수타입: ${3.14} <br>
문자열: ${"안녕하세요"} <br>
논리타입: ${true} <br>
null: ${null} <br>
<hr>
5+2: ${5+2} <br>
5-2: ${5-2} <br>
5*2: ${5*2} <br>
5/2: ${5/2} <br>
5%2: ${5%2} <br>
<hr>
5>2 : ${5>2} <br>
5>2 : ${5 gt 2} <br>
(5>2)?5:2 : ${(5>2)?5:2} <br>

</body>
</html>