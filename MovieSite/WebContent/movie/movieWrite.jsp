<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보 등록 페이지</title>
<link type="text/css" rel="stylesheet" href="css/movie.css">
</head>
<body>
	<div id="wrap">
		<h1>영화정보 등록 페이지</h1>
		<form action="MS" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="command" value="movie_write">
			<table>
				<tr>
					<th colspan="2">아이디/ 비밀번호 (*영화정보 수정 및 삭제시 필요*)</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid" required>*</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="userpwd" required>*</td>
				</tr>
				<tr>
					<th colspan="2">영화정보</td>
				</tr>
				<tr>
					<th>영화 제목</th>
					<td><input type="text" name="title" required>*</td>
				</tr>
				<tr>
					<th>감독명</th>
					<td><input type="text" name="director"></td>
				</tr>
				<tr>
					<th>주연배우</th>
					<td><input type="text" name="actor"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" name="price" step="1">원</td>
				</tr>
				<tr>
					<th>별점</th>
					<td><input type="text" name="score" step="0.01" max="10">점</td>
				</tr>
				<tr>
					<th>스틸컷(포스터)</th>
					<td><input type="file" name="steaelcut"></td>
				</tr>
				<tr>
					<th>줄거리</th>
					<td> <textarea rows="10" cols="30" name="content"></textarea> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="저장">
						<input type="reset" value="다시작성">
						<input type="button" value="목록으로 돌아가기" onclick="location.href='MS?command=movie_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>