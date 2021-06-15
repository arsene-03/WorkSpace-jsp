package com.coffee.q04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.coffee.vo.CoffeeVo;

@WebServlet("/CM")
public class coffeeMenu extends HttpServlet {
	 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt =null; 
		ResultSet rs = null;
		
		List<String> coffeeNames = new ArrayList<>();
		HttpSession session = request.getSession();
		
		
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "SELECT DISTINCT(coffeeName) FROM coffeeMenu";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String coffeeName = rs.getString(1);
				coffeeNames.add(coffeeName);
			}
			
			session.setAttribute("coffeeNames", coffeeNames);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {rs.close();}
				if(stmt !=null) {stmt.close();}	
				if(conn !=null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("coffeeMenu.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement psmt =null; 
		ResultSet rs = null;
		
		String coffeeName = request.getParameter("coffeeName");
		String coffeeType = request.getParameter("coffeeType");
		int coffeeCount = Integer.parseInt(request.getParameter("coffeeCount"));
		int coffeePrice =0;
		
		CoffeeVo cVo = null;
		HttpSession session = request.getSession();
		
		List<CoffeeVo> CoffeeVoList = (ArrayList)session.getAttribute("CoffeeVoList");
		
		if(CoffeeVoList==null) {
			CoffeeVoList = new ArrayList<>();
		}
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			
			conn = ds.getConnection();
			String sql = "SELECT coffeePrice FROM coffeeMenu Where coffeeName=? And coffeeType=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, coffeeName);
			psmt.setString(2, coffeeType);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				coffeePrice = rs.getInt(1);
			}
			
			cVo = new CoffeeVo(coffeeName, coffeeType,coffeePrice,coffeeCount);
			
			CoffeeVoList.add(cVo);
			session.setAttribute("CoffeeVoList", CoffeeVoList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {rs.close();}
				if(psmt !=null) {psmt.close();}	
				if(conn !=null) {conn.close();}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("coffeeMenu.jsp");
		dispatcher.forward(request, response);
	}

}
