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
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO pVo = dao.selectProductByCode(code);
		
		request.setAttribute("productVo", pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
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
			
			int code = Integer.parseInt(multi.getParameter("code"));
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String pictureurl = multi.getFilesystemName("pictureurl");
			String description = multi.getParameter("description");
			String originPic = multi.getParameter("originPic");
			
			if(pictureurl == null) {
				pictureurl = originPic;
			
			}
			ProductVO pVo = new ProductVO();
			pVo.setCode(code);
			pVo.setName(name);
			pVo.setPrice(price);
			pVo.setPictureurl(pictureurl);;
			pVo.setDescription(description);;
			
			
			
			ProductDAO dao = ProductDAO.getInstance();
			dao.updateProduct(pVo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("productList.do");
	}
}
