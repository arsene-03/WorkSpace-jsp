package com.vote.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vote.db.DBManager;
import com.vote.dto.MemberDTO;

public class VoteDAO {
	private VoteDAO(){}
	private static VoteDAO dao = new VoteDAO();
	
	public static VoteDAO getInstance() {
		return dao;
	}
	
	public List<MemberDTO> selectMember(){
		List<MemberDTO> memberlist = new ArrayList<>();
		
		String sql = "SELECT M_NO,M_NAME,P_CODE,P_SCHOOL,M_JUMIN,M_CITY,P_TEL1,P_TEL2,P_TEL3" + 
				"FROM TBL_MEMBER_202005 NATURAL JOIN TBL_PARTY_202005" + 
				"WHERE  P_CODE = P_CODE";
		
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
				dto.setM_CITY(rs.getString("setM_CITY"));
				dto.setTel(rs.getString("P_TEL1")+rs.getString("P_TEL2")+rs.getString("P_TEL3"));
				
				memberlist.add(dto);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, stmt, rs);
		}
		return memberlist;
	}
	
	
	
	
	
}





