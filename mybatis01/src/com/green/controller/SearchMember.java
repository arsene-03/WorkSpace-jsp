package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO2;
import com.green.vo.MemberVO;


@WebServlet("/SM")
public class SearchMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 폼으로 이동
		response.sendRedirect("member/searchMember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		MemberVO mVo = new MemberVO();
		mVo.setEmail(email);
		mVo.setName(name);
		
		MemberDAO2 dao2 = MemberDAO2.getInstance();
		List<MemberVO> lists= dao2.searchMember(mVo);
		
		request.setAttribute("lists", lists);
		
		String url = "member/lists.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
