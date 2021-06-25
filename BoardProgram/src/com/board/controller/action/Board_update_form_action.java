package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class Board_update_form_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("update-form 진입");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String url = "view/board_update_view.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO board = dao.selectEachBoard(idx);
		
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);

	}

}
