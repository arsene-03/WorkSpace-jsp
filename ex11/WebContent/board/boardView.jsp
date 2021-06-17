<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<link type="text/css" rel="stylesheet" href="css/board.css">
<script type="text/javascript" src="script/board.js"> </script>
</head>
<body>
<div id="wrap">
	<h1>게시물 상세보기</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td>${board.name}</td>
			<th>이메일</th>
			<td>${board.email}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${board.writedate}"/></td>
			<th>조회수</th>
			<td>${board.readcount}</td>
		</tr>
		<tr>
			<th>글 제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td colspan="3">${board.content}</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="게시글 수정" onclick="open_widow('BS?command=board_check_pass_form&num=${board.num}','update')">
				<input type="button" value="게시글 삭제" onclick="open_widow('BS?command=board_check_pass_form&num=${board.num}','delete')">
				<input type="button" value="목록으로 돌아가기" onclick="location.href='BS?command=board_list'">
			</td>
		</tr>
	</table>
</div>
</body>
</html>