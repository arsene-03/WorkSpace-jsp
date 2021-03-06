package com.green.ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userid = request.getParameter("userid");
		String userpassword = request.getParameter("userpassword");
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		
		System.out.println("아이디: "+userid);
		System.out.println("비밀번호: "+userpassword);
		System.out.println("이름: "+username);
		
		if(gender.equals("male")) {
			System.out.println("성별: 남성");
		}else {
			System.out.println("성별: 여성");
		}
		
		for(String hobby:hobbys) {
			System.out.println("취미: "+hobby);
		}
		System.out.println("doGET메서드 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String userpassword = request.getParameter("userpassword");
		String username = request.getParameter("username");
		System.out.println("아이디: "+userid);
		System.out.println("비밀번호: "+userpassword);
		System.out.println("이름: "+username);
		System.out.println("doPOST 메서드 실행");
	}

}
