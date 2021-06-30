package com.score.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.score.controller.action.Action;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/SS")
public class ScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("요청 : "+command);
		
		ActionFactory af = ActionFactory.getInsetance();
		Action action = af.getAction(command);
		
		if(action!=null) {
			action.excute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
