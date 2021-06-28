<%@page import="com.sun.org.apache.bcel.internal.generic.GETSTATIC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.course.vo.CourseVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수간신청 리스트 페이지</title>
<link type="text/css" rel="stylesheet" href="./css/course.css">
</head>
<body>
	<div id="wrap">
		<%@ include file="../include/header.jsp" %>
		<section>
			<table border="1">
				<tr>
					<th>과목코드</th>
					<th>과목명</th>
					<th>학점</th>
					<th>담당강사</th>
					<th>요일</th>
					<th>시작시간</th>
					<th>종료시간</th>
					<th>관리</th>
				</tr>
<%
					List<CourseVO> courselist = (List)request.getAttribute("courselist");
			
					int count = 0;
					for(CourseVO course:courselist){
						count++;
%>
				<tr>
<%				
					
	
						out.println("<td>"+course.getId()+"</td>");
						out.println("<td>"+course.getName()+"</td>");
						out.println("<td>"+course.getCredit()+"</td>");
						out.println("<td>"+course.getLecturer()+"</td>");
						
						String week = null;
						switch(course.getWeek()){
							case 1: week="월요일";break;
							case 2: week="화요일";break;
							case 3: week="수요일";break;
							case 4: week="목요일";break;
							case 5: week="금요일";break;
							case 6: week="토요일";break;
						}
						
						out.println("<td>"+week+"</td>");
						
						String start = String.valueOf(course.getStart_hour());
						String end = String.valueOf(course.getEnd_hour());
						if(course.getStart_hour()<1000){
							start = "0"+start;
						}
						out.println("<td>"+start+"</td>");
						
						if(course.getEnd_hour()<1000){
							end = "0"+start;
						}
						out.println("<td>"+end+"</td>");
						out.println("<td><a href='CS?command=course_update_form&id="+course.getId()+"'>수정 </a>/<a href='CS?command=course_del&id="+course.getId()+"'> 삭제</a></td>");
%>
</tr>
<%
				
					}
					out.println("<h3>총"+count+"개의 교과목이 있습니다.</h3>");
%>				
			</table>
			<table id="buts">
				<tr><td>
				<input type="button" id="but" value="작성" onclick="location.href='CS?command=course_write_form'">
				</td></tr>
			</table>	
		</section>
		<%@ include file="../include/footer.jsp" %>
	</div>
</body>
</html>

