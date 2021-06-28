package com.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class Comment_write_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("write 진입");
		
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		System.out.println(bidx);
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		System.out.println("DAO 실행");
		dao.writeComment(bidx,writer,content);
		
		String url = "BS?command=board_info&idx="+bidx;
		response.sendRedirect(url);
	}

}
