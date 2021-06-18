<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보 리스트 페이지</title>
<link type="text/css" rel="stylesheet" href="css/movie.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>영화정보 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="7" style="border:white; text-align: right">
					<a href="MS?command=movie_write">영화정보 등록하기</a>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>제목</th>
				<th>감독명</th>
				<th>주연배우</th>
				<th>가격</th>
				<th>별점</th>
			</tr>
			<c:forEach var="movie" items="${movieList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td class="listSteel"><img src="upload/${movie.steelcut}" ></td>
					<td>${movie.title}</td>
					<td>${movie.director}</td>
					<td>${movie.actor}</td>
					<td>${movie.price}</td>
					<td>${movie.score}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>