package com.movie.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.vo.MovieVO;

public class MovieWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieVO mVo = new MovieVO();
		mVo.setTitle(request.getParameter("title"));
		mVo.setDirector(request.getParameter("director"));
		mVo.setActor(request.getParameter("actor"));
		mVo.setPrice(Integer.parseInt(request.getParameter("price")));
		mVo.setContent(request.getParameter("content"));
		mVo.setScore(Double.parseDouble(request.getParameter("score")));
		mVo.setUserid(request.getParameter("userid"));
		mVo.setUserpwd(request.getParameter("userpwd"));
		mVo.setSteelcut(request.getParameter("steelcut"));
		
		
	}

}
