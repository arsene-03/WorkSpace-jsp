<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
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
	ResultSet rs = null;
		
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uId = "greenJSP";
	String uPw = "1234";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String coffeeName = request.getParameter("coffeeName");
	String cupSize = request.getParameter("cupSize");

	int cup = Integer.parseInt(request.getParameter("cup"));
	String sql = "SELECT coffeeName, ? FROM cafeMenu WHERE coffeeName='?'";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uId, uPw);
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, cupSize);
		psmt.setString(2, coffeeName);
		rs = psmt.executeQuery();
		
		while(rs.next()){
			out.println(rs.getString("coffeeName"));
			out.println(rs.getString("cupSize"));
			
			
			//session.setAttribute("coffeeName", rs.getString("coffeeName"));
			//session.setAttribute("type", cupSize);
			//session.setAttribute("price", rs.getString(cupSize));
			//response.sendRedirect("aa.jsp");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null){rs.close();}
			if(psmt != null){rs.close();}
			if(conn != null){rs.close();}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</body>
</html>