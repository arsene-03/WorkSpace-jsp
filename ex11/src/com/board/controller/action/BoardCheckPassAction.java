package com.board.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		if(dao.checkPassword(pass, num)) { //비밀번호 일치
			System.out.println("암호일치");
			url = "board/checkSuccess.jsp";
		}else { //비밀번호 오류
			System.out.println("암호불일치");
			url = "board/boardCheckPass.jsp";
			request.setAttribute("msg", "비밀번호 오류 입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
	
}
