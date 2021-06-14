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
<title>데이터 삽입</title>
</head>
<body>
<%!
Connection conn = null;
Statement stmt = null;
//ResultSet rs = null; // 쿼리가 SELECT문일 경우 필요

String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 서버 주소+포트+SID
String uId = "greenJSP"; // 접속 계정
String uPw = "1234"; // 접속비밀번호
%>

<%
String name = "최길동";
String userId = "choi";
String userPwd = "1234";
String email = "choi@naver.com";
String phone = "010-1234-5678";
int admin = 0;

String sql = 
	"INSERT INTO member VALUES "+
	"('"+name+"','"+userId+"','"+userPwd+"','"+email+"','"+phone+"','"+admin+"')";

	try{
		// 1단계: 드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
		// 2단계: 데이터베이스 연결
		conn = DriverManager.getConnection(url,uId,uPw);
				
		// 3단계: 쿼리문 실행할 객체 생성
		stmt = conn.createStatement();
	
		// 4단계: 쿼리문 실행
		int num = stmt.executeUpdate(sql);
		System.out.println("바뀐행의 개수: "+num);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
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

</body>
</html>