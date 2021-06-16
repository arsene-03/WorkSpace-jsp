<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정페이지</title>
<link type="text/css" href="css/product.css" rel="stylesheet">
</head>
<body>
<div id="wrap" align="center">
	<h1>상품 수정 페이지 - 관리자</h1>
	<form action="productUpdate.do" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td rowspan="4">
					<c:choose>
						<c:when test="${empty productVo.pictureurl}">
							<img src="upload/noimage.jpg">
						</c:when>
						<c:otherwise>
							<img src="upload/${productVo.pictureurl}">
						</c:otherwise>
					</c:choose>
				</td>
				<th>상품명</th>
				<td>
					<input type="text" name="name" value="${productVo.name}">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="price" value="${productVo.price}"> 
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="pictureurl"> <br> 
					(주의사항 : 이미지를 변경하고자 할 때만 선택하세요)
					<input type="hidden" name = "orginPic" value="${productVo.pictureurl}">
					<input type="hidden" name = "code" value="${productVo.code}">
				</td>
			</tr>
			<tr>
				<th>설명</th>
				<td>
					<textarea rows="10" cols="90" name="description">${productVo.description}</textarea> 
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="변경">
					<input type="reset" value="다시작성">
					<input type="button" value="목록으로 가기" onclick="location.href='productList.do'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>