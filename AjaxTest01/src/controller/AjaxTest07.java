package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.MemberDTO;

/**
 * Servlet implementation class AjaxTest07
 */
@WebServlet("/AjaxTest07")
public class AjaxTest07 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserId("asdf");
		dto.setUserName("홍길동");
		dto.setUserPwd("1234");
		
		Gson gson = new Gson();
		
		String dtoJson = gson.toJson(dto);
			
		PrintWriter out = response.getWriter();
		
		out.println(dtoJson);
	}

}
