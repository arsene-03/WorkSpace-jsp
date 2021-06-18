package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.movie.db.DBManager;
import com.movie.vo.MovieVO;

public class MovieDAO {
	
	private MovieDAO() {}
	
	private static MovieDAO dao = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return dao;
	}
	
	//모든 영화정보 조회
	public List<MovieVO> selectAllMovies(){
		
		List<MovieVO> movieList = new ArrayList<>();
		
		String sql = "SELECT * FROM favoriteMovie ORDER BY code DESC";
									
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MovieVO mVo = new MovieVO();
				
				mVo.setCode(rs.getString("code"));
				mVo.setTitle(rs.getString("title"));
				mVo.setDirector(rs.getString("director"));
				mVo.setActor(rs.getString("actor"));
				mVo.setPrice(rs.getInt("price"));
				mVo.setContent(rs.getString("content"));
				mVo.setScore(rs.getDouble("score"));
				mVo.setReadcount(rs.getInt("readcount"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setSteelcut(rs.getString("steelcut"));
				
				
				movieList.add(mVo);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, stmt, rs);
		}
		return movieList;
	}
	
	
	//영화정보 등록
	
	public void insertMovie(MovieVO mVo) {
		
		String sql = "INSERT INTO favoriteMovie (title, director, actor, price, content, score, userid, userpwd, steelcut)"
						+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mVo.getTitle());
			psmt.setString(2, mVo.getDirector());
			psmt.setString(3, mVo.getActor());
			psmt.setInt(4, mVo.getPrice());
			psmt.setString(5, mVo.getContent());
			psmt.setDouble(6, mVo.getScore());
			psmt.setString(7, mVo.getUserid());
			psmt.setString(8, mVo.getUserpwd());
			psmt.setString(9, mVo.getSteelcut());
			
			psmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.Close(conn, psmt);
		}
		
	}
	
	
	
	
//	//전체 영화정보 갯수 알아오기
//	public int selectAllMovie() {
//		int cntAll = 0;
//		
//		String sql = "SELECT * FROM favoriteMoive";
//		
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//
//		try {
//			conn = DBManager.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			
//			if(rs.next()) {
//				cntAll = rs.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.Close(conn, stmt, rs);
//		}
//		return cntAll;
//	}
//	
//	
//	//리스트 조회기능 (페이지별
//	public List<MovieVO> selectTargetMovie(int section, int page){
//		List<MovieVO> movieList = new ArrayList<>();
//		
//		String sql = "SELECT * FROM (SELECT ROWNUM AS countRow, code, title, director, actor, price, content, score, readcount, userid, userpwd, steelcut "
//						+"FROM (SELECT * FROM favoriteMoive ORDER BY code DESC))" +
//							"WHERE countRow BETWEEN (?-1)*100+(?-1)*10+1 AND (?-1)*100+?*10";
//		
//		Connection conn = null;
//		PreparedStatement psmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBManager.getConnection();
//			psmt = conn.prepareStatement(sql);
//			
//			psmt.setInt(1, section);
//			psmt.setInt(2, page);
//			psmt.setInt(1, section);
//			psmt.setInt(2, page);
//			
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				MovieVO mVo = new MovieVO();
//				
//				mVo.setCode(rs.getString("code"));
//				mVo.setTitle(rs.getString("title"));
//				mVo.setDirector(rs.getString("director"));
//				mVo.setActor(rs.getString("actor"));
//				mVo.setPrice(rs.getInt("price"));
//				mVo.setContent(rs.getString("content"));
//				mVo.setScore(rs.getDouble("score"));
//				mVo.setReadcount(rs.getInt("readcount"));
//				mVo.setUserid(rs.getString("userid"));
//				mVo.setUserpwd(rs.getString("userpwd"));
//				mVo.setSteelcut(rs.getString("steelcut"));
//				
//				
//				movieList.add(mVo);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.Close(conn, psmt);
//		}
//		return movieList;
//	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
