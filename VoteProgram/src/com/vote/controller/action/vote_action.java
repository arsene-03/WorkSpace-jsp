package com.vote.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.dao.VoteDAO;
import com.vote.dto.VoteDTO;

public class vote_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VoteDTO dto = new VoteDTO();
		
		dto.setV_JUMIN(request.getParameter("V_JUMIN"));
		dto.setV_NAME(request.getParameter("V_NAME"));
		dto.setM_NO(request.getParameter("M_NO"));
		dto.setV_TIME(request.getParameter("V_TIME"));
		dto.setV_AREA(request.getParameter("V_AREA"));
		dto.setV_CONFIRM(request.getParameter("V_CONFIRM"));
		
		VoteDAO dao =VoteDAO.getInstance();
		
		dao.insertVote(dto);
		
		response.sendRedirect("http://localhost:8085/VoteProgram/index.jsp");
	

	}

}
