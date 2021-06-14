<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource" %>
<%@page import="javax.naming.InitialContext" %>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			이름
			</th>
			<th>
			아이디
			</th>
			<th>
			비밀번호
			</th>
			<th>
			이메일
			</th>
			<th>
			전화번호
			</th>
			<th>
			권한(1:관리자, 0:사용자)
			</th>
		</tr>
		<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member";
		
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
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
				if(rs !=null){rs.close();}
				if(stmt !=null){stmt.close();}
				if(conn !=null){conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//etc.
		%>
	</table>
</body>
</html>