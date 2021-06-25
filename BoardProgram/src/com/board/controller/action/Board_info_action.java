package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;
import com.board.vo.CommentVO;

public class Board_info_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("info_action 진입");
		String url = "view/board_info_view.jsp";
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO board = dao.selectEachBoard(idx);
		List<CommentVO> commentlist = dao.selectEachComment(idx);
		
		request.setAttribute("board", board);
		request.setAttribute("commentlist", commentlist);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);

	}

}
