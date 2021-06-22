package com.vote.controller.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.vote.dao.VoteDAO;
import com.vote.db.DBManager;
import com.vote.dto.MemberDTO;

public class selectMember_Action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = "/vote/selectMember_view.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		
		List<MemberDTO> memberlist =dao.selectMember();
		
		request.setAttribute("memberlist", memberlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
