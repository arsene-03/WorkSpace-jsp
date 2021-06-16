package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import com.product.vo.ProductVO;

public class ProductDAO {

	private ProductDAO() {}
	
	private static ProductDAO dao = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return dao;
	}
	
	//연결 객체를 얻어 오기위한 메서드
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//연결을 종료시키기 위한 메서드
	//1. SELECT를 수행후 종료하기 위한 메서드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
			if(conn != null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//2. insert, delete, update 를 수행후 종료하기 위한 메서드
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null) {stmt.close();}
			if(conn != null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//전체 데이터를 읽어오는 메서드 작성
	public List<ProductVO> selectAllProduct(){
		List<ProductVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM productTbl ORDER BY code DESC";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				list.add(pVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
		return list;
	}
	
	// 상품 등록
	public void insertProduct(ProductVO pVo) {
		String sql = "INSERT INTO productTbl VALUES (product_seq.nextval,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pVo.getName());
			psmt.setInt(2, pVo.getPrice());
			psmt.setString(3, pVo.getPictureurl());
			psmt.setString(4, pVo.getDescription());
		
			psmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, psmt);
		}
	}
	
	//상품 상세보기
	public ProductVO selectProductByCode(String code) {
		
		ProductVO pVo= null;
		
		String sql = "SELECT * FROM productTbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(code));
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getNString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getNString("pictureurl"));
				pVo.setDescription(rs.getNString("description"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn,psmt,rs);
		}
		return pVo;
	}
	
	
	//상품 수정
	public void updateProduct(ProductVO pVo) {
		
		String sql = "UPDATE productTbl SET name=?,price=?,pictureurl=?,description=? WHERE code=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pVo.getName());
			psmt.setInt(2, pVo.getPrice());
			psmt.setString(3, pVo.getPictureurl());
			psmt.setString(4, pVo.getDescription());
			psmt.setInt(5, pVo.getCode());
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt);
		}
	}
	
	
	//상품 삭제
	public void deleteProduct(int code) {
		
		String sql = "DELETE FROM productTbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, code);
				
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,psmt);
		}
		
	}
	
	
	
	
	
	
	
}
