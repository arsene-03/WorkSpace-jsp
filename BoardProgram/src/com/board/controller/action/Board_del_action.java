package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class Board_del_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("board_delete 진입"));
		
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(idx);;
		
		String url = "BS?command=board_list";
		response.sendRedirect(url);
	}

}
