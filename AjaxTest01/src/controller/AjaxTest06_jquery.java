package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.javafx.scene.paint.GradientUtils.Parser;


@WebServlet("/AjaxTest06")
public class AjaxTest06_jquery extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userData = request.getParameter("userData");
		System.out.println(userData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(userData);
		
		String userId = data.getAsJsonObject().get("userId").getAsString();
		String userName = data.getAsJsonObject().get("userName").getAsString();
		String userPwd = data.getAsJsonObject().get("userPwd").getAsString();
		
		System.out.println("넘어온 아이디: "+userId);
		System.out.println("넘어온 이름: "+userName);
		System.out.println("넘어온 암호: "+userPwd);
		
	}

}
