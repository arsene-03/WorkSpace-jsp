package com.green.Practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Covid
 */
@WebServlet("/CovidAction")
public class CovidAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CovidAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int random = (int)(Math.random()*100);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("userName");
		String bodyTem = request.getParameter("bodyTem");
		double userTem = Double.parseDouble(bodyTem);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head>");
		out.println("<body>");
		if(userTem<37.5){
			out.println("<h1>"+userName+"님 코로나 '음성'입니다."+"</h1>");
		}else if(random<=19){
			out.println("<h1>"+userName+"님 코로나 '양성'입니다."+"</h1>");
		}else{
			out.println("<h1>"+userName+"님 코로나 '음성'입니다."+"</h1>");
		}
	}

}
