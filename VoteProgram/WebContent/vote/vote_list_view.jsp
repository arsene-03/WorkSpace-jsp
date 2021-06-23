<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>    
<%@ page import="com.vote.dto.VoteDTO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표검수조회</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/nav.jsp"%>
	<section class="section">
		<h1>투표검수조회</h1>
		<table border="1">
			<tr>
				<th>성명</th>
				<th>생년월일</th>
				<th>나이</th>
				<th>성별</th>
				<th>후보번호</th>
				<th>투표시간</th>
				<th>유권자확인</th>
			</tr>
				<%
				List<VoteDTO> votelist = (List)request.getAttribute("votelist");
				
				for(VoteDTO vote:votelist){
			%>
			<tr>
			<%
			//성명
			out.println("<td>"+vote.getV_NAME()+"</td>");
			
			//생년월일
			String jumin = vote.getV_JUMIN();
			String birth = "19"+jumin.substring(0,2)+"년"
								+jumin.substring(2,4)+"월"
								+jumin.substring(4,6)+"일생";
			out.println("<td>"+birth+"</td>");
			
			//나이
			
			
			
			out.println("<td></td>"); 
			
			//성별
			String gender = null;
			if(jumin.substring(6,7).equals("1")||jumin.substring(6,7).equals("3")){
				gender = "남";
			}else{
				gender = "여";
			}
			out.println("<td>"+gender+"</td>");
			
			//후보번호
			out.println("<td>"+vote.getM_NO()+"</td>");
			
			//투표시간
			String time = vote.getV_TIME();
			String times = time.substring(0, 2)+":"+time.substring(2, 4);
			out.println("<td>"+times+"</td>");
			
			//유권자확인
			String confirm = vote.getV_CONFIRM();
			String concheck = null;
			if(confirm.equals("Y")||confirm.equals("y")){
				concheck = "확인";
			}else{
				concheck = "미확인";
			}			
			out.println("<td>"+concheck+"</td>");		
				}
				%>
			</tr>
		
		</table>
	</section>
<%@ include file="../include/footer.jsp"%>
</body>
</html>