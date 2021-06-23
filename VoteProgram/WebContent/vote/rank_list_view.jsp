<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>    
<%@ page import="com.vote.dto.RankDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자등수</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/nav.jsp"%>
	<section class="section">
		<h1>후보자등수</h1>
		<table border=1>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>총투표건수</th>
			</tr>
			<%
				List<RankDTO> ranklist = (List)request.getAttribute("ranklist");
				
				for(RankDTO rank:ranklist){
			%>
			<tr>
			<%
			//후보번호
			out.println("<td>"+rank.getM_NO()+"</td>");
			
			//성명
			out.println("<td>"+rank.getM_NAME()+"</td>");
			
			//총투표건수
			out.println("<td>"+rank.getCOUNT()+"</td>");
			}
				%>
			</tr>
	
		</table>
	</section>
<%@ include file="../include/footer.jsp"%>
</body>
</html>