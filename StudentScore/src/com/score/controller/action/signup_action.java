package com.score.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.score.dao.ScoreDAO;
import com.score.dto.MemberDTO;

public class signup_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "SS?command=login_form_action";
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userClass = request.getParameter("userClass");
		String type = request.getParameter("type");
		
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(userName);
		System.out.println(userClass);
		System.out.println(type);
		
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPwd(userPwd);
		dto.setUserClass(userClass);
		dto.setType(type);
		
		ScoreDAO dao = ScoreDAO.getInstance();
		dao.signupMember(dto);
		
		response.sendRedirect(url);
		
	}

}
