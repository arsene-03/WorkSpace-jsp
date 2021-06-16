package com.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.product.dao.ProductDAO;
import com.product.vo.ProductVO;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String savePath = "upload";
		
		int fileSize = 100*1024*1024;
		
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String path = context.getRealPath(savePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,
					path,
					fileSize,
					encType,
					new DefaultFileRenamePolicy()
					);
			
			ProductVO pVo = new ProductVO();
			pVo.setName(multi.getParameter("name"));
			pVo.setPrice(Integer.parseInt(multi.getParameter("price")));
			pVo.setPictureurl(multi.getFilesystemName("pictureurl"));
			pVo.setDescription(multi.getParameter("description"));
			
			ProductDAO dao = ProductDAO.getInstance();
			dao.insertProduct(pVo);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("productList.do");
	}

}
