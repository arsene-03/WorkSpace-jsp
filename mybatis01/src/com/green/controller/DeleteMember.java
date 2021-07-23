package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO2;


@WebServlet("/DM")
public class DeleteMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 폼으로 이동
		response.sendRedirect("member/deleteMemberForm.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 
		 String email = request.getParameter("email");
		 
		 MemberDAO2 dao2 = MemberDAO2.getInstance();
		 dao2.deleteMember(email);
		 
		 String url="index.jsp";
		 RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		 dispatcher.forward(request, response);
	}

}
