package com.score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.score.db.DBManager;
import com.score.dto.MemberDTO;

public class ScoreDAO {
	private ScoreDAO() {};
	private static ScoreDAO dao = new ScoreDAO();
	public static ScoreDAO getInstance() {
		return dao;
	}
	
	public void signupMember(MemberDTO dto ) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			String table = null;
			if(dto.getType().equals("student")) {
				table = "student_tbl";
			}else if(dto.getType().equals("teacher")){
				table = "teacher_tbl";
			}
			System.out.println("테이블이름: "+table);
			
			String sql = "INSERT INTO "+table
					+" VALUES (?,?,?,?)";
			
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserId());
			psmt.setString(2, dto.getUserName());
			psmt.setString(3, dto.getUserPwd());
			psmt.setString(4, dto.getUserClass());
			psmt.execute();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}
		
	}
	
	
	public MemberDTO loginChkStu(String userId) {
		
		String sql = "SELECT * FROM student_tbl WHERE stuId=?";
		MemberDTO dto = new MemberDTO();
		
		Connection conn =null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				dto.setUserId(rs.getString("stuId"));
				dto.setUserPwd(rs.getString("stuPwd"));
				dto.setUserName(rs.getString("stuName"));
				dto.setUserClass(rs.getString("stuClass"));
				dto.setType("student");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt, rs);
		}
		return dto;
	}

	public MemberDTO loginChkTea(String userId) {
		String sql = "SELECT * FROM teacher_tbl WHERE teaId=?";
		MemberDTO dto = new MemberDTO();
		
		Connection conn =null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				dto.setUserId(rs.getString("teaId"));
				dto.setUserPwd(rs.getString("teaPwd"));
				dto.setUserName(rs.getString("teaName"));
				dto.setUserClass(rs.getString("teaClass"));
				dto.setType("teacher");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt, rs);
		}
		return dto;
	}
	
	
	
	
	
	
	
	
	
}
