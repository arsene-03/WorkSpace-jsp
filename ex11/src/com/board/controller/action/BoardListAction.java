package com.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class BoardListAction implements Action { //서블릿처럼 동작하게됨

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실제적으로 게시물 리스트를 가져와서 view에 연결해 주는 메서드
		
		String url = "/board/boardList.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardlist = dao.selectAllBoards();
		
		request.setAttribute("boardlist", boardlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
