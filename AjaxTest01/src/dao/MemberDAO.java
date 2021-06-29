package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DBManager;
import dto.MemberDTO;

public class MemberDAO {
	private MemberDAO() {};
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	public String chkId(String userId) {
		String sql = "SELECT * FROM MemberTest WHERE userId = '"+userId+"'";
		
		String chkid = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				chkid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return chkid;
	}


	public void insertUsers(MemberDTO dto) {
		String sql ="INSERT INTO MemberTest VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserId());
			psmt.setString(2, dto.getUserName());
			psmt.setString(3, dto.getUserPwd());
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}
		
	}
	
	
	
	
	
	
	
	
	
}
