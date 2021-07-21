package com.green.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.MemberVO;

public class MemberDAO {

	private MemberDAO() {}
	private static MemberDAO dao =  new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	/////////////////////////////////////////////////////
	
	public List<MemberVO> selectAll(){
		List<MemberVO> lists = new ArrayList<>();
		
		String sql = "SELECT * FROM member";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setId(rs.getLong("id"));
				mVo.setEmail(rs.getString("email"));
				mVo.setName(rs.getString("name"));
				mVo.setPassword(rs.getString("password"));
				mVo.setRegdate(rs.getDate("regdate"));
				
				lists.add(mVo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
			
		return lists;
	}
	
}
