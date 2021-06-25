<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.board.vo.BoardVO"%>
<%@ page import="com.board.vo.CommentVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회 페이지</title>
</head>
<body>
	<div id="wrap">
		<%@ include file="../include/header.jsp"%>
		<section>
			<h1>게시물조회</h1>
			<table >
				<tr>
					<td colspan="2">
						제목 : ${board.subject}
					</td>
				</tr>
				<tr>
					<td>작성자 : ${board.writer}</td>
					<td>작성일 : ${board.time}</td>
				</tr>
				<tr>
					<td>${board.content}</td>
				</tr>

			</table>		
			<table>
				<tr>
					<td>댓글 조회</td>
				</tr>
				<tr>
<%
			List<CommentVO> commentlist = (List)request.getAttribute("commentlist");
			
			for(CommentVO comm:commentlist){
%>
				<tr>
<%	
					out.println("<td>"+comm.getWriter()+"</td><td>/</td>");
					out.println("<td>"+comm.getContent()+"</td><td>/</td>");
					out.println("<td>"+comm.getTime()+"</td><td>/</td>");
					out.println("<td><a href='BS?command=comment_Delete&idx="+comm.getIdx()+"&bidx="+comm.getBidx()+"'>삭제<a></td>");
%>
				</td>
<%
			}				
%>								
			</table>
			
			<table>
				<tr>
					<td>댓글 작성</td>
					<td>

					</td>
				</tr>
				<tr>
					<td>							
						<form action="BS" method="POST">
						<input type="hidden" name="command" value="comment_write">
						<input type="hidden" name ="bidx" value="${board.idx}">
						<input type="text" name ="writer">
						<input type="text" name ="content">
						<input type="submit" value="작성완료">
						</form>
						
			

					</td>
				</tr>
				
			</table>
	
			<input type="button" value="목록" onclick="location.href='BS?command=board_list'">
			<input type="button" value="수정" onclick="location.href='BS?command=board_update_form&idx=${board.idx}'">
			<input type="button" value="삭제" onclick="location.href='BS?command=board_delete&idx=${board.idx}'">

		</section>	
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>