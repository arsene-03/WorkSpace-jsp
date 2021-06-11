<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품등록 페이지</h1>
	<form action="Shopping_list.jsp" method="GET">
		<fieldset>
			<legend>상품정보</legend>
			<label for="proName">상품명: </label>
			<input type="text" name="proName" id="proName">
			<label for="proCode">상품코드: </label>
			<input type="text" name="proCode" id="proCode">
			<label for="proPrice">가격: </label>
			<input type="text" name="proPrice" id="proPrice">
			<label for="proMaker">제조사: </label>
			<input type="text" name="proMaker" id="proMaker">
			<label for="proMaterial">주요원료: </label>
			<input type="text" name="proMaterial" id="proMaterial">
			<label for="proSold">품절여부: </label>
			<input type="text" name="proSold" id="proSold">
			<input type="submit" value="상품등록">
		</fieldset>
	</form>
</body>
</html>