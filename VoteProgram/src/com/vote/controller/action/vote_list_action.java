package com.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.dao.VoteDAO;
import com.vote.dto.VoteDTO;

public class vote_list_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/vote_list_view.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		
		List<VoteDTO> votelist =dao.selectVote();
		
		request.setAttribute("votelist", votelist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
