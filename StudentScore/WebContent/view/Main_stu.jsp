<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.score.dto.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생메인페이지</title>
<link type="text/css" rel="stylesheet" href="../css/score.css">
</head>
<body>
		<div id="wrap">
		<%@include file="../include/header.jsp" %>
		<section id="middle">
			<%
				HttpSession sess = request.getSession();
				MemberDTO member = (MemberDTO)sess.getAttribute("member");
				
				if(member.getUserId()==null){
					%>
					<script>
						alert('로그인을 해주세요');
						location.href='SS?command=login_form_action'
					</script>
			<%
				}else{
					out.println("<h1>안녕하세요 "+member.getUserName()+"님</h1>");
					
					
				}
			%>
			
		</section>
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>