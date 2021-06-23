<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<link type="text/css" rel="stylesheet" href="css/vote.css">
<script type="text/javascript" src="script/vote.js"></script>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/nav.jsp"%>
	<section class="section">
		<h1>투표하기</h1>
		<form action="VS" method="POST" name="frm">
			<input type="hidden" name="command" value="vote_write">
			<table border="1">
				<tr>
					<th>주민번호</th>
					<td class = in><input type="text" name="V_JUMIN"> 예 : 8906153154726</td>
				</tr>
				<tr>
					<th>성명</th>
					<td class = in><input type="text" name="V_NAME"></td>
				</tr>
				<tr>
					<th>후보번호</th>
					<td class = in> 
						<select name="M_NO">
							<option value="1">[1] 김후보</option>
							<option value="2">[2] 이후보</option>
							<option value="3">[3] 박후보</option>
							<option value="4">[4] 조후보</option>
							<option value="5">[5] 최후보</option>
						</select>
					</td>
				</tr>
				<tr >
					<th>투표시간</th>
					<td class = in><input type="text" name="V_TIME"></td>
				</tr>
				<tr>
					<th>투표장소</th>
					<td class = in><input type="text" name="V_AREA"></td>
				</tr>
				<tr>
					<th>유권자확인</th>
					<td class = in><input type="radio" name="V_CONFIRM" value="Y">확인
						<input type="radio" name="V_CONFIRM" value="N">미확인
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="투표하기" onclick="return submitChk()">
						<input type="reset" value="다시하기">
					</td>
				</tr>
			</table>
		</form>
	</section>
<%@ include file="../include/footer.jsp"%>
</body>
</html>