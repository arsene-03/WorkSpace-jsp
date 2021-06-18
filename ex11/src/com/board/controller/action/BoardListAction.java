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
		
//		String url = "/board/boardList.jsp";
//		
//		BoardDAO dao = BoardDAO.getInstance();
//		List<BoardVO> boardlist = dao.selectAllBoards();
//		
//		request.setAttribute("boardlist", boardlist);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
		
		//페이징 처리
		String url = "/board/boardList.jsp";
		
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		int section = Integer.parseInt((_section==null)?"1":_section);
		int pageNum = Integer.parseInt((_pageNum==null)?"1":_pageNum);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int totalCnt =  dao.selectAllNumBoard();
		List<BoardVO> boardList = dao.selectTargetBoard(section, pageNum);
		
		request.setAttribute("section", section);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
