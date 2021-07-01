package com.score.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.score.dao.ScoreDAO;
import com.score.dto.MemberDTO;

public class login_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginFailUrl = "script/loginFail.jsp";

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		ScoreDAO dao = ScoreDAO.getInstance();

		MemberDTO memStu = dao.loginChkStu(userId);

		if(memStu.getUserId()!=null) {
			if(memStu.getUserPwd().equals(userPwd)) { //학생로그인성공
				HttpSession session = request.getSession();
				session.setAttribute("member", memStu);
				String url = "script/stuLogin.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else {
				response.sendRedirect(loginFailUrl);//비밀번호 오류 로그인 실패
			}
		}else{
			MemberDTO memTea = dao.loginChkTea(userId);
			if(memTea.getUserId()!=null) {
				if(memTea.getUserPwd().equals(userPwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("member", memTea);
					String url = "script/teaLogin.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}else {
					response.sendRedirect(loginFailUrl);//비밀번호 오류 로그인 실패
				}
			}else {
				response.sendRedirect(loginFailUrl);//가입된 정보 x
			}
		}
	}

}
