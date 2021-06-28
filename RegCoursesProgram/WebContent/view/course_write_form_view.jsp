<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 정보 추가 페이지</title>
<link type="text/css" rel="stylesheet" href="./css/course.css">
</head>
<body>
<div id="wrap">
		<%@ include file="../include/header.jsp" %>
		<section>
			<h3 id="title">교과목 추가</h3>
			<form action="CS" method="POST">
				<input type="hidden" name="command" value="course_write">
			<table border="1" id= "formtb">
				<tr>
					<th>과목코드</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>과목명</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>담당강사</th>
					
					<td id="selradi"> 
						<select name="lecturer">
							<option value = "김교수">김교수</option>
							<option value = "이교수">이교수</option>
							<option value = "박교수">박교수</option>
							<option value = "우교수">우교수</option>
							<option value = "최교수">최교수</option>
							<option value = "강교수">강교수</option>
							<option value = "황교수">황교수</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>학점</th>
					<td><input type="text" name="credit"></td>
				</tr>
				<tr >
					<th>요일</th>
					<td id="selradi">
						<input type="radio" name="week" value="1">월
						<input type="radio" name="week" value="2">화
						<input type="radio" name="week" value="3">수
						<input type="radio" name="week" value="4">목
						<input type="radio" name="week" value="5">금
						<input type="radio" name="week" value="6">토
					</td>
				</tr>
				<tr>
					<th>시작시간</th>
					<td><input type="text" name="start_hour" maxlength="4"></td>
				</tr>
				<tr>
					<th>종료시간</th>
					<td><input type="text" name="end_hour" maxlength="4"></td>
				</tr>		
			</table>
			<table id="buts2">
				<tr><td>
				<input type="button" id="but" value="목록" onclick="location.href='CS?command=course_list'">
				<input type="submit" value="완료">
				</td></tr>
			</table>	
			</form>
		</section>
		<%@ include file="../include/footer.jsp" %>
	</div>	
</body>
</html>