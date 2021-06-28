package com.course.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.dao.CourseDAO;
import com.course.vo.CourseVO;

import sun.rmi.server.Dispatcher;

public class Course_list_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "view/course_list_view.jsp";
		
		CourseDAO dao = CourseDAO.getInsetance();
		
		List<CourseVO> courselist = dao.selectCourselist();
		
		request.setAttribute("courselist", courselist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
