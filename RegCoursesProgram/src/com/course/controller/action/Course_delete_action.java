package com.course.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.dao.CourseDAO;

public class Course_delete_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="CS?command=course_list";
		
		String id = request.getParameter("id");
		
		CourseDAO dao = CourseDAO.getInsetance();
		dao.deleteCourse(id);
		
		response.sendRedirect(url);

	}

}
