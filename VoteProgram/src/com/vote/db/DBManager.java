package com.vote.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","greenJSP","1234");
		return conn;	
	}
	
	//SELECT 문 닫을때
	public static void Close(Connection conn, Statement stmt, ResultSet rs) {
		
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//INSERT UPDATE DELETE 닫을때
	public static void Close(Connection conn, Statement stmt) {
		
		try {
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
