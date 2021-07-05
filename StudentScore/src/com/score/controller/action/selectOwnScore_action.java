package com.score.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.score.dao.ScoreDAO;
import com.score.dto.MemberDTO;
import com.score.dto.ScoreDTO;

public class selectOwnScore_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/selectOwnScore_list_view.jsp";
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		String stuName = member.getUserName();
		
		ScoreDAO dao = ScoreDAO.getInstance();
		ScoreDTO sdto = dao.seletOwnScore(stuName);
		
		request.setAttribute("score", sdto);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
