package com.green.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.beans.Member;

/**
 * Servlet implementation class inputMember
 */
@WebServlet("/IM")
public class inputMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 자바빈 객체 생성
		
		Member member = new Member();
		
		//2. 자바빈 객체의 프로퍼티 저장
		member.setUserId("hong");
		member.setUserName("홍길동");
		
		//3. 리퀘스트 내장객체에 자바빈 객체 저장
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex08_result.jps");
	}

}
