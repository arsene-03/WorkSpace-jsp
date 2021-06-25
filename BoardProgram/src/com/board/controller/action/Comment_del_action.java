package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class Comment_del_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("idx"));
		
		
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteComment(idx);
		
		String url = "BS?command=board_info&idx="+bidx;
		response.sendRedirect(url);
	}

}
