<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>    
<%@ page import="com.vote.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보조회</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
</head>
<body>
<div id="wrap">
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/nav.jsp"%>
	<section class="section">
		<h1>후보조회</h1>
		<table border="1">
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표번호</th>
			</tr>
			<%
				List<MemberDTO> memberlist = (List)request.getAttribute("memberlist");
			
					for(MemberDTO member:memberlist){
			%>
			<tr>
			<%
				out.println("<td>"+member.getM_NO()+"</td>");
				out.println("<td>"+member.getM_NAME()+"</td>");
				
				String code = member.getP_CODE();
				String codeName = null;
				switch(code){
					case "P1": codeName = "A정당"; break;
					case "P2": codeName = "B정당"; break;
					case "P3": codeName = "C정당"; break;
					case "P4": codeName = "D정당"; break;
					case "P5": codeName = "E정당"; break;		
				}
				out.println("<td>"+codeName+"</td>");
				
				String school = member.getP_SCHOOL();
				String schoolName = null;
				switch(school){
					case "1": schoolName = "고졸"; break;
					case "2": schoolName = "학사"; break;
					case "3": schoolName = "석사"; break;
					case "4": schoolName = "박사"; break;		
				}
				out.println("<td>"+schoolName+"</td>");
				out.println("<td>"+member.getM_JUMIN()+"</td>");
				out.println("<td>"+member.getM_CITY()+"</td>");
				out.println("<td>"+member.getTel()+"</td>");
			%>	
			</tr>
			<%
					}
		%>
		</table>
	</section>
<%@ include file="../include/footer.jsp"%>
</div>
</body>
</html>