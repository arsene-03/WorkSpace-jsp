<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.board.vo.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트 페이지</title>
</head>
<body>
	<div id="wrap">
		<%@ include file="../include/header.jsp"%>
		<section>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
<%
				List<BoardVO> boardlist = (List)request.getAttribute("boardlist");
				int count=0;
				for(BoardVO board:boardlist){
					
					count++;
%>				
				<tr>
<%			
					
					//번호
					out.println("<td>"+board.getIdx()+"</td>");
		
					//작성자
					out.println("<td>"+board.getWriter()+"</td>");
		
					//제목
					out.println("<td><a href='BS?command=board_info&idx="+board.getIdx()+"'>"+board.getSubject()+"</td>");
			
					//작성일
					String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(board.getTime());
					
					out.println("<td>"+time+"</td>");
				}
%>
				</tr>
				<tr>
<%
					out.println("총 "+count+"개의 게시물이 있습니다.");
%>
				</tr>
		</table>
			<input type="button" value="작성" onclick="location.href='BS?command=board_write'">
		</section>	
		<%@ include file="../include/footer.jsp"%>
	</div>
</body>
</html>