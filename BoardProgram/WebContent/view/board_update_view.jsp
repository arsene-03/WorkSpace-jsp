<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정페이지</title>
</head>
<body>
	<div id="wrap">
		<%@ include file="../include/header.jsp"%>
		<section>
			<h2>게시물 작성</h2>
			<form action="BS" method="POST">
				<input type="hidden" name="command" value="board_update">
				<input type="hidden" name="idx" value="${board.idx}">
				<table>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="${board.writer}"></td>
					</tr>
									<tr>
						<th>제목</th>
						<td><input type="text" name="subject" value="${board.subject}"></td>
					</tr>
									<tr>
						<th>내용</th>
						<td> <textarea rows="10" cols="20" name="content">${board.content}</textarea></td>
					</tr>
				</table>
					<input type="button" value="취소" onclick="location.href='BS?command=board_info&idx=${board.idx}'">
					<input type="submit" value="완료">
			</form>
		</section>	
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>