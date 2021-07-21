package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.dao.MemberDAO2;
import com.green.vo.MemberVO;


@WebServlet("/FS")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "member/lists.jsp";
		////////////////////////////////////////////////////
		// 기존에 DBMS에 접속해서 데이터를 가져오는 코드
//		MemberDAO dao = MemberDAO.getInstance();
//		List<MemberVO> lists= dao.selectAll();
//		request.setAttribute("lists", lists);
		
		// 마이바티스를 통해서 데이터를 가져오는 코드
		MemberDAO2 dao2 = MemberDAO2.getInstance();
		List<MemberVO> lists= dao2.selectAll();
		request.setAttribute("lists", lists);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
