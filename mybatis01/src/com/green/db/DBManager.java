package com.green.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {  //데이터베이스와 연결을 위한 객체
	
	public static Connection getConnection() {// 데이터 베이스와 연결을 위한 메서드
		Connection conn = null;
		// 데이터 베이스와 연결을 위해서 4가지 정보
		String driver = "oracle.jdbc.driver.OracleDriver"; //드라이버
		String url = "jdbc:oracle:thin:@localhost:1521:XE";  //주소:포트:sid
		String uId = "greenJSP"; //계정
		String uPw = "jsp1234"; //비밀번호
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uId,uPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt !=null) {stmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
