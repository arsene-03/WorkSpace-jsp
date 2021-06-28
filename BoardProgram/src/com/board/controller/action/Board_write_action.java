package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class Board_write_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.writeBoard(writer, subject, content);
		
		String url = "BS?command=board_list";
		
		response.sendRedirect(url);

	}

}
