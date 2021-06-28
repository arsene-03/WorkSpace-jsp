package com.course.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.dao.CourseDAO;
import com.course.vo.CourseVO;

public class Course_write_action implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CS?command=course_list";
		
		String lec = request.getParameter("lecturer");
		
		CourseVO cVo = new CourseVO();
		cVo.setId(request.getParameter("id"));
		cVo.setName(request.getParameter("name"));
		cVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		cVo.setLecturer(request.getParameter("lecturer"));
		cVo.setWeek(Integer.parseInt(request.getParameter("week")));
		cVo.setStart_hour(Integer.parseInt(request.getParameter("start_hour")));
		cVo.setEnd_hour(Integer.parseInt(request.getParameter("end_hour")));
		
		CourseDAO dao = CourseDAO.getInsetance();
		int num = dao.selectlectureridx(lec);
		System.out.println(num);
		
		dao.insertCourse(cVo,num);
		
		response.sendRedirect(url);
	}

}
