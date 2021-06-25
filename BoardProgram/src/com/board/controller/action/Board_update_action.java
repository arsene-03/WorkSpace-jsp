package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class Board_update_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update 진입");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(idx, writer, subject, content);
		
		String url = "BS?command=board_info&idx="+idx;
		response.sendRedirect(url);
	}

}
