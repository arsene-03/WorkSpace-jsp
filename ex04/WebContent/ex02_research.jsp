<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex02_result.jsp" method="POST">
		이름: <input type="text" name="userName"> 
		<br>
		<fieldset>
			<legend>성별</legend>
				남성 <input type="radio" name=jender value=male>
				여성 <input type="radio" name=jender value=female>
		</fieldset>
		<fieldset>
			<legend>좋아하는계절</legend>
				봄<input type="checkbox" name=season value="spring"> <br>
				여름<input type="checkbox" name=season value="summer"><br>
				가을<input type="checkbox" name=season value="autumn"><br>
				겨울<input type="checkbox" name=season value="winter"><br>
		</fieldset>
		<input type="submit" value="입력">
	</form>
</body>
</html>