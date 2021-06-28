package com.course.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.dao.CourseDAO;
import com.course.vo.CourseVO;

import sun.rmi.server.Dispatcher;

public class Course_update_form_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "view/course_update_form_view.jsp";
		
		String id = request.getParameter("id");
		
		CourseDAO dao = CourseDAO.getInsetance();
		CourseVO course = dao.selectEachCourse(id);
		
		request.setAttribute("course", course);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
