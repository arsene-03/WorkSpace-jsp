package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AjaxTest08")
public class AjaxTest08 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String str = "";
		
		str = "<main>"+
				"<book>"+
					"<title>이것이 자바다</title>"+
					"<writer>신용권</title>"+
				"</book>"+
				"<book>"+
					"<title>이것이 오라클이다</title>"+
					"<writer>우재남</title>"+
				"</book>"+
			"<main>";
		
		PrintWriter out = response.getWriter();
		out.println(str);
	}

}
