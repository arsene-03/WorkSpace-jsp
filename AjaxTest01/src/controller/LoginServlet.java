package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/LS")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		
		String userId = request.getParameter("userId");
		System.out.println("GET/넘어온 값 : "+userId);
		
		MemberDAO dao = MemberDAO.getInstance();
		String userChkId = dao.chkId(userId);
		System.out.println(userChkId);
			
		PrintWriter out = response.getWriter();
		if(userChkId!=null) {
			 msg = "중복된 아이디 입니다.";
		}else {
			 msg = "사용할 수 있는 아이디 입니다.";
			 
		}

		out.println(msg);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userName);
		System.out.println(userPwd);
		
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPwd(userPwd);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertUsers(dto);
		
		String url = "Login.jsp";
		
		response.sendRedirect(url);
	}

}
