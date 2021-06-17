package com.board.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {	//DB 연결과 담당할 메서드
	
	//DB 연결을 위한 메서드
	public static Connection getConnection() { //DBManager.getConnection();
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//DB 해제하기 위한 메서드
	//1. RS 해제포함 - SELECT를 수행 후 연결해제
	public static void Close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//2. RS 해제미포함 - INSERT UPDATE DELETE를 수행 후 연결해제
	public static void Close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
