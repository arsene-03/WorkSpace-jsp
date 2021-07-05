<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.score.dto.MemberDTO" %>
<%@ page import="com.score.dto.ScoreDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인성적 조회페이지</title>
<link type="text/css" rel="stylesheet" href="css/score.css">
</head>
<body>
		<div id="wrap">
		<%@include file="../include/header.jsp" %>
		<%@include file="../include/nav_stu.jsp" %>
		<section id="middle">
			<%
				HttpSession sess = request.getSession();
				
				
				if(sess.getAttribute("member")==null){
					%>
					<script>
						alert('로그인을 해주세요');
						location.href='SS?command=login_form_action'
					</script>
			<%
				}else{
			%>
					<table border=1>
						<tr>
							<th>이름</th>
							<th>국어점수</th>
							<th>영어점수</th>
							<th>수학점수</th>
							<th>과학점수</th>
							<th>사회점수</th>
						</tr>
						<tr>
						<%
						ScoreDTO score =(ScoreDTO)request.getAttribute("score");
						
						out.println("<td>"+score.getStuName()+"</td>");
						out.println("<td>"+score.getKorScore()+"</td>");
						out.println("<td>"+score.getEngScore()+"</td>");
						out.println("<td>"+score.getMathScore()+"</td>");
						out.println("<td>"+score.getSciScore()+"</td>");
						out.println("<td>"+score.getSocScore()+"</td>");
						
						
						%>
					</table>
			<%
				}
			%>
			
		</section>
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>