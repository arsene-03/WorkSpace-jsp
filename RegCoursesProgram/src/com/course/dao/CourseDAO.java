package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.course.db.DBManager;
import com.course.vo.CourseVO;

public class CourseDAO {
	
	private CourseDAO (){};
	
	private static CourseDAO dao = new CourseDAO();
	
	public static CourseDAO getInsetance() {
		return dao;
	}
	
	////////////////////////////////////////////////////
	public List<CourseVO> selectCourselist() {
		
		List<CourseVO> courselist = new ArrayList<>();
		
		String sql = "SELECT c.id,c.name,c.credit,l.name as lname,c.week,c.start_hour,c.end_hour "
					+"FROM course_tbl c, lecturer_tbl l "
					+"Where c.lecturer = l.idx "
					+"ORDER BY c.id ASC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				CourseVO cVo = new CourseVO();
				
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getString("lname"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
				
				courselist.add(cVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return courselist;
	}

	////////////////////////////////////////////////////
	public int selectlectureridx(String lec) {
		String sql = "SELECT idx FROM lecturer_tbl WHERE name= '"+lec+"'";
		
		int lecturere = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				lecturere = rs.getInt("idx");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return lecturere;
	}
	
	
	////////////////////////////////////////////////////
	public void insertCourse(CourseVO cVo, int num) {
		
		String sql = "INSERT INTO course_tbl VALUES (?,?,?,?,?,?,?)"; 
		
		String lecturere = String.valueOf(num);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setString(4, lecturere);
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}

	}

	public void deleteCourse(String id) {

		String sql = "DELETE FROM course_tbl WHERE id ="+id;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt);
		}
		
	}

	public CourseVO selectEachCourse(String id) {
		
		String sql = "SELECT * FROM course_tbl WHERE id ="+id;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		CourseVO cVo = new CourseVO();
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				cVo.setId(rs.getString("id")); 
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getString("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return cVo;
	}

	public void updateCourse(CourseVO cVo, int num) {
		
		String sql = "UPDATE course_tbl SET id=?, name=?, credit=?, lecturer=?, week=?, start_hour=? end_hour=?"; 
		
		String lecturere = String.valueOf(num);
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setString(4, lecturere);
			psmt.setInt(5, cVo.getWeek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			psmt.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}

	}


}
