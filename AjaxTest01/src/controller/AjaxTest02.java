package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


@WebServlet("/AjaxTest02")
public class AjaxTest02 extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userData = request.getParameter("userData");
		
		//System.out.println("넘어온 값 : "+userData);
		
		JsonParser parser = new JsonParser(); // Json으로 된 데이터를 분해하기 위한 도구
		
		JsonElement data = parser.parse(userData);
		
		String userId = data.getAsJsonObject().get("userId").getAsString();
		String userName = data.getAsJsonObject().get("userName").getAsString();
		String userPwd = data.getAsJsonObject().get("userPwd").getAsString();
		
		System.out.println("꺼내온 아이디 : "+userId);
		System.out.println("꺼내온 이름 : "+userName);
		System.out.println("꺼내온 암호 : "+userPwd);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		
		String userData = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		
		InputStream is = request.getInputStream();
		
		if(is!=null) {
			br = new BufferedReader(new InputStreamReader(is));
			char[] charBuffer = new char[100];
			int byteRead = -1;
			
			while((byteRead = br.read(charBuffer))>0) {
				sb.append(charBuffer,0,byteRead);
			}
		}
		
		br.close();
		is.close();
		
		userData = sb.toString();
		System.out.println("POST/넘어온 값 : "+userData);
		
		JsonParser parser = new JsonParser(); // Json으로 된 데이터를 분해하기 위한 도구
		
		JsonElement data = parser.parse(userData);
		
		String userId = data.getAsJsonObject().get("userId").getAsString();
		String userName = data.getAsJsonObject().get("userName").getAsString();
		String userPwd = data.getAsJsonObject().get("userPwd").getAsString();
		
		System.out.println("꺼내온 아이디 : "+userId);
		System.out.println("꺼내온 이름 : "+userName);
		System.out.println("꺼내온 암호 : "+userPwd);
		
		
		
	}

}
