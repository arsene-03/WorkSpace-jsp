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
	
	
	public boolean loginChkStu(String userId) {
		
		String sql = "SELECT * FROM student_tbl WHERE stuId='"+userId+"'";
		
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			MemberDTO dto = new MemberDTO();
			while(rs.next()) {
				dto.setUserId(rs.getString("stuId"));
				dto.setUserPwd(rs.getString("userPwd"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserClass(rs.getString("userClass"));
				dto.setType("student");
			}
			if(dto.getUserId()==null) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
}
