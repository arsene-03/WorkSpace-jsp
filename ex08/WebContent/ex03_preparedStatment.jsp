<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet" %>    
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
Connection conn = null;
PreparedStatement psmt = null;
//ResultSet rs = null; // 쿼리가 SELECT문일 경우 필요

String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 서버 주소+포트+SID
String uId = "greenJSP"; // 접속 계정
String uPw = "1234"; // 접속비밀번호
%>
<%
String name = "강길동";
String userId = "kang";
String userPwd = "1234";
String email = "kang@naver.com";
String phone = "010-1234-5678";
int admin = 0;

String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";

	try{
		// 1단계: 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2단계: 데이터베이스 연결
		conn = DriverManager.getConnection(url,uId,uPw);
		
		// 3단계: 쿼리문 실행할 객체 생성
		psmt = conn.prepareStatement(sql); // 미리 쿼리문(미완성)을 넣는다.
		
		// 4단계: 미완성 쿼리문을 채워야 한다.
		psmt.setString(1, name);
		psmt.setString(2, userId);
		psmt.setString(3, userPwd);
		psmt.setString(4, email);
		psmt.setString(5, phone);
		psmt.setInt(6, admin);
		
		//5단계: 쿼리문 실행 => sql을 넣지 않는다.
		int num = psmt.executeUpdate();
		System.out.println("바뀐행의 개수: "+num);
		
	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		try{

			if(psmt != null){
				psmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</body>
</html>