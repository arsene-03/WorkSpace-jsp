package com.score.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.score.dao.ScoreDAO;

public class login_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		ScoreDAO dao = ScoreDAO.getInstance();
		
		boolean chk = dao.loginChkStu(userId);
		
		if(chk==true) {
			System.out.println("로그인성공");
		}else {
			System.out.println("로그인실패");
		}
	}

}
