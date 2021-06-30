<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.board.vo.BoardVO"%>
<%@ page import="com.board.vo.CommentVO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회 페이지</title>
<link type="text/css" rel="stylesheet" href="../css/board.css">
</head>
<body>
	<div id="wrap">
		<%@ include file="../include/header.jsp"%>
		<section>
			<div id="boardinfo">
			<h3>게시물조회</h3>
			<table >
<%
		BoardVO board = (BoardVO)request.getAttribute("board");
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(board.getTime());
%>
				<tr>
					<td colspan="2">
						제목 : ${board.subject}
					</td>
				</tr>
				<tr>
					<td>작성자 : ${board.writer}</td>
<%
					out.println("<td>작성일 : "+time+"</td>");
%>
				</tr>
				<tr>
					<td colspan="2" id="content">${board.content}</td>
				</tr>

			</table>	
			</div>	
			<table id="commentList">
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
			
			<table id="commentWrite">
				<tr>
					<td colspan="2">댓글 작성</td>
					<td>

					</td>
				</tr>
				<tr>
					<td>							
						<form action="BS" method="POST">
						<input type="hidden" name="command" value="comment_write">
						<input type="hidden" name ="bidx" value="${board.idx}">
						이름: <input type="text" name ="writer" size="10px">
						내용: <input type="text" name ="content" size="60px">
						<input type="submit" value="작성완료">
						</form>
					</td>
				</tr>
				
			</table>
			<table id="buts">
				<tr><td>	
				<input type="button" value="목록" onclick="location.href='BS?command=board_list'">
				<input type="button" value="수정" onclick="location.href='BS?command=board_update_form&idx=${board.idx}'">
				<input type="button" value="삭제" onclick="location.href='BS?command=board_delete&idx=${board.idx}'">
				</td></tr>
			</table>
		</section>	
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>