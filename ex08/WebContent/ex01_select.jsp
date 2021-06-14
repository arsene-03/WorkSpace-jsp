<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>    
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 베이스 조회</title>
</head>
<body>
<%!
//선언부는 첫 방문자에 의해 한번만 수행하면 된다.
Connection conn = null;
Statement stmt = null;
ResultSet rs = null; // 쿼리가 SELECT문일 경우 필요

String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 서버 주소+포트+SID
String uId = "greenJSP"; // 접속 계정
String uPw = "1234"; // 접속비밀번호

String sql = "SELECT * FROM member";

%>

<table border="1">
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>암호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>권한(1:관리자, 0:일반회원)</th>
	</tr>
	<%
	
	try{
		// 1단계: 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2단계: 데이터베이스 연결
		conn = DriverManager.getConnection(url,uId,uPw);
		
		// 3단계: 쿼리문 실행할 객체 생성
		stmt = conn.createStatement();
		
		// 4단계: 쿼리문 실행
		rs = stmt.executeQuery(sql); // => 읽어오기 위한 메서드    
		//stmt.executeUpdate(sql); => 기록을 위한 메서드
		
		// 5단계: 데이터 꺼내서 출력하기
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString("name")+"</td>");
			out.println("<td>"+rs.getString("userId")+"</td>");
			out.println("<td>"+rs.getString("userPwd")+"</td>");
			out.println("<td>"+rs.getString("email")+"</td>");
			out.println("<td>"+rs.getString("phone")+"</td>");
			out.println("<td>"+rs.getInt("admin")+"</td>");
			out.println("</tr>");
		}
	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	%>
</table>


</body>
</html>