package com.green.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultiFileupload
 */
@WebServlet("/upload2.do")
public class MultiFileupload extends HttpServlet {

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String upLoadFilePath = "C://Study//upload"; // 업로드 폴더
		int uploadFileSizeLimit = 5*1024*1024 ;//최대 업로드 파일 크기(합산) => 5MB = 5KB*1024 = 5byte*1024*1024
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, 
					upLoadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy()
					);
			if(multi == null) {
				System.out.println("업로드 실패");
			}else {
				System.out.println("업로드 성공");
			}
			
			Enumeration<String> fileNames =multi.getFileNames();
			while(fileNames.hasMoreElements()) {
				String file = (String)fileNames.nextElement(); // 가져온 이름 name : uploadFile01
				String fileName = multi.getFilesystemName(file); // uploadFile01을 이용해 실제 파일 이름 가져오기
				
				String originFileName =multi.getOriginalFileName(file); // 정책에 의해 변경되기 전 원본파일명 나옴
				out.println("<br>업로드된 파일명 : "+fileName);
				out.println("<br>원본 파일명 : "+originFileName);
				out.println("<hr>");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
