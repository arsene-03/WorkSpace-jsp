package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO2;
import com.green.vo.MemberVO;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/UM")
public class UpdateMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력 폼으로 이동
				response.sendRedirect("member/updateMemberForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력된 데이터를 DBMS에 저장
				request.setCharacterEncoding("UTF-8");
				String email = request.getParameter("email");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				
				MemberVO mVo = new MemberVO();
				mVo.setEmail(email);
				mVo.setName(name);
				mVo.setPassword(password);
				
				MemberDAO2 dao2 = MemberDAO2.getInstance();
				dao2.updateMember(mVo);
				
				String url = "index.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
	}

}
