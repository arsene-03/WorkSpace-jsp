package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class Board_list_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "view/board_list_view.jsp";
		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> boardlist = dao.selectBoard();
		
		request.setAttribute("boardlist", boardlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);
		
	
	}

}
