package com.green.Practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class scoreAction
 */
@WebServlet("/scoreAction")
public class scoreAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scoreAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String score1 = request.getParameter("score1");
		String score2 = request.getParameter("score2");
		String score3 = request.getParameter("score3");
		String score4 = request.getParameter("score4");
		String score5 = request.getParameter("score5");
		
		int socre1 = Integer.parseInt(score1);
		int socre2 = Integer.parseInt(score2);
		int socre3 = Integer.parseInt(score3);
		int socre4 = Integer.parseInt(score4);
		int socre5 = Integer.parseInt(score5);
		
		
		
		int sumScore = socre1+socre2+socre3+socre4+socre5;
		double avgScore = sumScore/5;
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+"총점: "+sumScore+"</h1>");
		out.println("<h1>"+"평균: "+avgScore+"</h1>");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
