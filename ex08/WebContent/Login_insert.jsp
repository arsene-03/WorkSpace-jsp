<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

String url = "jdbc:oracle:thin:@localhost:1521:XE";
String uId = "greenJSP";
String uPw = "1234";
%>

<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
int admin = Integer.parseInt(request.getParameter("admin"));

String sql = "INSERT INTO member VALUES (?,?,?,?,?,?)";

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,uId,uPw);
	psmt = conn.prepareStatement(sql);
	psmt.setString(1, name);
	psmt.setString(2, userId);
	psmt.setString(3, userPwd);
	psmt.setString(4, email);
	psmt.setString(5, phone);
	psmt.setInt(6, admin);
	
	int num = psmt.executeUpdate();
	if(num !=0){
		System.out.println("행이 삽입되었습니다");	
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(psmt != null){psmt.close();}
		if(conn != null){conn.close();}
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>

<h3>회원 가입 성공</h3>
<a href="ex01_select.jsp">회원정보 보기</a>
</body>
</html>