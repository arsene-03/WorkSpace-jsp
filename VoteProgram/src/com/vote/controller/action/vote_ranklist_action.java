package com.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.dao.VoteDAO;
import com.vote.dto.RankDTO;

public class vote_ranklist_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/rank_list_view.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		
		List<RankDTO> ranklist =dao.rankVote();
		
		request.setAttribute("ranklist", ranklist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
