package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.MemberVO;

public class MemberDAO { //데이터 베이스 연동을 위한 클래스
	// 싱글톤 구성
	private MemberDAO() {};
	
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	//////////////////////////////////////
	// 데이터 베이스 연결 객체를 만드는 메서드
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		
		return conn;
	}
	
	
	//////////////////////////////////////
	// 아이디 정보를 통해서 회원 정보를 찾아 오는 메서드
	// 아이디와 비밀번호로 저장된 아이디, 비밀번호 일치 여부 인증처리하는 메서드
	
	public MemberVO getMember(String userId) {
		MemberVO mVo = null;
		String sql = "SELECT * FROM member WHERE userId=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserId(rs.getString("userId"));
				mVo.setUserPwd(rs.getString("userPwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}
	
	///////////////////////////////////////////////////
	//사용자 인증처리 메서드
	public int userCheck(String userId, String userPwd){
		int result = -1;
		
		String sql = "SELECT userPwd FROM member WHERE userId=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("userPwd")!=null
						&&rs.getString("userPwd").equals(userPwd)) {
					result = 1; // 로그인성공
				
				}else {
					result = 0; // 비밀번호가 null이거나 , 일치하지 않는 경우
				}
			}else {
				result = -1; //아이디를 찾을 수 없는 경우
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	/////////////////////////////////////////////////////////
	//아이디 중복체크를 위한 메서드
	public int confirmID(String userId) {
		int result = -1;
		String sql = "SELECT userid FROM member WHERE userId =?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = 1; //아이디가 존재함.
			}else {
				result = -1; // 중복된 아이디 x
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	////////////////////////////////////////////////////
	//회원 가입 시 사용할 쿼리문 작성메서드
	public int insertMember(MemberVO mVo) {
		int result = -1;
		
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getName());
			psmt.setString(2, mVo.getUserId());
			psmt.setString(3, mVo.getUserPwd());
			psmt.setString(4, mVo.getEmail());
			psmt.setString(5, mVo.getPhone());
			psmt.setInt(6, mVo.getAdmin());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	
	///////////////////////////////////////////////////////////////
	//회원정보를 업데이트 하기 위한 쿼리를 작동시킬 메서드
	public int updateMember(MemberVO mVo) {
		int result = -1;
		
		String sql = "UPDATE member SET userPwd=?, email=?, phone=?, admin=? WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getUserPwd());
			psmt.setString(2, mVo.getEmail());
			psmt.setString(3, mVo.getPhone());
			psmt.setInt(4, mVo.getAdmin());
			psmt.setString(5, mVo.getUserId());
			
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null) {psmt.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
