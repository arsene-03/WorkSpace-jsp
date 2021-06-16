package com.green.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

/**
 * Servlet implementation class Fileupload
 */
@WebServlet("/upload.do")
public class Fileupload extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String savePath = "Upload"; // 업로드 폴더
		int uploadFileSizeLimit = 5*1024*1024 ;//최대 업로드 파일 크기(합산) => 5MB = 5KB*1024 = 5byte*1024*1024
		String encType = "UTF-8";
		
		//ServletContext context = getServletContext();
		//String uploadFilePath = context.getRealPath(savePath);//서버상의 실제 업로드 디렉터리
		String uploadFilePath = "C:/Study/Upload";
			// C:/study/~~~
		System.out.println("서버상의 실제 디렉토리 : "+uploadFilePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, // 폼으로 부터 얻어온 request객체
					uploadFilePath, // 서버상의 실제 디렉터리 위치
					uploadFileSizeLimit, // 최대 업로드 파일 크기
					encType,
					new DefaultFileRenamePolicy()//동일 이름의 파일 이름이 잇을 경우 사용할 정책 => 동일 파일이 존재할 경우 새로운 이름을 부여
					);
			String fileName = multi.getFilesystemName("fileupload"); //업로드가 정상적으로 되었다면 읽어올 파일이름을 얻기
			
			if(fileName == null) { //파일 업로드 실패
				System.out.println("파일 업로드 실패");
			}else {
				
				out.println("<br> 글쓴이: "+multi.getParameter("name"));
				out.println("<br> 글제목: "+multi.getParameter("title"));
				out.println("<br> 파일명: "+fileName);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
