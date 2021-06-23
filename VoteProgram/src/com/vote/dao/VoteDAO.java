package com.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vote.db.DBManager;
import com.vote.dto.MemberDTO;
import com.vote.dto.RankDTO;
import com.vote.dto.VoteDTO;

public class VoteDAO {
	private VoteDAO(){}
	private static VoteDAO dao = new VoteDAO();
	
	public static VoteDAO getInstance() {
		return dao;
	}
	
	public List<MemberDTO> selectMember(){
		List<MemberDTO> memberlist = new ArrayList<>();
		
		String sql = "SELECT M.M_NO,M.M_NAME,M.P_CODE,M.P_SCHOOL,M.M_JUMIN,M.M_CITY,P.P_TEL1,P.P_TEL2,P.P_TEL3 FROM TBL_MEMBER_202005 M ,TBL_PARTY_202005 P WHERE  M.P_CODE = P.P_CODE";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setM_NO(rs.getString("M_NO"));
				dto.setM_NAME(rs.getString("M_NAME"));
				dto.setP_CODE(rs.getString("P_CODE"));
				dto.setP_SCHOOL(rs.getString("P_SCHOOL"));
				dto.setM_JUMIN(rs.getString("M_JUMIN"));
				dto.setM_CITY(rs.getString("M_CITY"));
				dto.setTel(rs.getString("P_TEL1")+"-"+rs.getString("P_TEL2")+"-"+rs.getString("P_TEL3"));
				
				memberlist.add(dto);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, stmt, rs);
		}
		return memberlist;
	}
	
	public void insertVote(VoteDTO dto){
		
		String sql = "INSERT INTO TBL_VOTE_202005 VALUES(?,?,?,?,?,?)";
				
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getV_JUMIN());
			psmt.setString(2, dto.getV_NAME());
			psmt.setString(3, dto.getM_NO());
			psmt.setString(4, dto.getV_TIME());
			psmt.setString(5, dto.getV_AREA());
			psmt.setString(6, dto.getV_CONFIRM());
			
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, psmt);
		}
	}
	
	public List<VoteDTO> selectVote(){
		
		List<VoteDTO> votelist = new ArrayList<>();
		
		String sql = "SELECT * FROM TBL_VOTE_202005";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				VoteDTO dto = new VoteDTO();
				
				dto.setV_JUMIN(rs.getString("V_JUMIN"));
				dto.setV_NAME(rs.getString("V_NAME"));
				dto.setM_NO(rs.getString("M_NO"));
				dto.setV_TIME(rs.getString("V_TIME"));
				dto.setV_AREA(rs.getString("V_AREA"));
				dto.setV_CONFIRM(rs.getString("V_CONFIRM"));
				
				votelist.add(dto);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, stmt, rs);
		}
		return votelist;
	}
	
	
	public List<RankDTO> rankVote(){
		List<RankDTO> ranklist = new ArrayList<>();
		
		String sql = "SELECT v.M_NO, m.M_NAME, COUNT(*)"
					+" FROM TBL_VOTE_202005 v, TBL_MEMBER_202005 m"
					+" WHERE v.M_NO = m.M_NO"
					+" AND v.V_CONFIRM = 'Y'"
					+" GROUP BY v.M_NO,m.M_NAME"
					+" ORDER BY COUNT(*) DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				RankDTO dto = new RankDTO();
				
				dto.setM_NO(rs.getString("M_NO"));
				dto.setM_NAME(rs.getString("M_NAME"));
				dto.setCOUNT(rs.getString("COUNT(*)"));
				
				ranklist.add(dto);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, stmt, rs);
		}
		return ranklist;
	}
	
	
}





