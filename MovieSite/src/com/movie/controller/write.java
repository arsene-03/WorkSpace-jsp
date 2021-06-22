package com.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.MovieDAO;
import com.movie.vo.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class write
 */
@WebServlet("/write.do")
public class write extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("입력서블릿 진입");
		
		String url = "movie/movieWrite.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("입력서블릿(전송후)진입");
		
		request.setCharacterEncoding("UTF-8");
		
		

		String savePath = "upload";
		
		int fileSize = 100*1024*1024;
		
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String path = context.getRealPath(savePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,
					path,
					fileSize,
					encType,
					new DefaultFileRenamePolicy()
					);
			
			MovieVO mVo = new MovieVO();
			mVo.setTitle(multi.getParameter("title"));
			mVo.setDirector(multi.getParameter("director"));
			mVo.setActor(multi.getParameter("actor"));
			mVo.setPrice(Integer.parseInt(multi.getParameter("price")));
			mVo.setContent(multi.getParameter("content"));
			mVo.setScore(Double.parseDouble(multi.getParameter("score")));
			mVo.setUserid(multi.getParameter("userid"));
			mVo.setUserpwd(multi.getParameter("userpwd"));
			mVo.setSteelcut(multi.getFilesystemName("steelcut"));
			System.out.println(multi.getFilesystemName("steelcut"));
			MovieDAO dao = MovieDAO.getInstance();
			dao.insertMovie(mVo);			
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("MS?command=movie_list");
	}

}
