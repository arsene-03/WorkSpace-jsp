package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.board.db.DBManager;
import com.board.vo.CommentVO;
import com.board.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {};
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return dao;
	}
	
	//게시물 리스트 불러오기
	public List<BoardVO> selectBoard(){
		
		List<BoardVO> boardlist = new ArrayList<>();
		
		String sql = "SELECT * FROM board_tbl ORDER BY time";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				
				bVo.setIdx(rs.getInt("idx"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setSubject(rs.getString("subject"));
				bVo.setContent(rs.getString("content"));
				bVo.setTime(rs.getTimestamp("time"));
				
				boardlist.add(bVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return boardlist;
	}
	
	//각각 게시물 상세보기
	public BoardVO selectEachBoard(int idx){

		
		String sql = "SELECT * FROM board_tbl WHERE idx="+idx;
		
		BoardVO bVo = new BoardVO();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				bVo.setIdx(rs.getInt("idx"));
				bVo.setSubject(rs.getString("subject"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setContent(rs.getString("content"));
				bVo.setTime(rs.getTimestamp("time"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return bVo;
	}
	
	//각각 게시물의 댓글불러오기
	public List<CommentVO> selectEachComment(int idx){
	
		List<CommentVO> commentlist = new ArrayList<>();
		
		String sql = "SELECT * FROM comment_tbl WHERE bidx="+idx;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CommentVO cVo = new CommentVO();
				
				cVo.setIdx(rs.getInt("idx"));
				cVo.setBidx(rs.getInt("bidx"));
				cVo.setWriter(rs.getString("writer"));
				cVo.setContent(rs.getString("content"));
				cVo.setTime(rs.getTimestamp("time"));
				
				commentlist.add(cVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, stmt, rs);
		}
		return commentlist;
		
	}

	//게시물의 댓글 삭제
	public void deleteComment(int idx) {
		
		String sql = "DELETE FROM comment_tbl WHERE idx="+idx;
		
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

	public void writeComment(int bidx, String writer, String content) {
		
		String sql = "INSERT INTO comment_tbl VALUES (comment_seq.nextval,?,?,?,?)";
		
		String strtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
		Timestamp time = Timestamp.valueOf(strtime);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bidx);
			psmt.setString(2, writer);
			psmt.setString(3, content);
			psmt.setTimestamp(4, time);
			
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}
	}
	
	public void updateBoard(int idx, String writer, String subject, String content) {
		
		String sql = "UPDATE board_tbl SET writer=?, subject=?, content=? WHERE idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, writer);
			psmt.setString(2, subject);
			psmt.setString(3, content);
			psmt.setInt(4, idx);
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}
	}
	
	public void deleteBoard(int idx) {
		
		String sql = "DELETE FROM board_tbl WHERE idx="+idx;
		
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
	
	public void writeBoard(String writer, String subject, String content) { //writer subject content time
		String sql = "INSERT INTO board_tbl VALUES (board_seq2.nextval,?,?,?,?)";
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, writer);
			psmt.setString(2, subject);
			psmt.setString(3, content);
			psmt.setTimestamp(4, time);
			
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.Close(conn, psmt);
		}
	}

	
	
	
	
}
