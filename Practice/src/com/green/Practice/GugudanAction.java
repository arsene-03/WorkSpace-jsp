package com.green.Practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanAction
 */
@WebServlet("/GugudanAction")
public class GugudanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GugudanAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dans[] = request.getParameterValues("dan");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<style>");
		out.println("*{");
		out.println("width: 100px;");
		out.println("text-align: center;");
		out.println("}");
		out.println("</style>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<table border=1>");
		for(String dan:dans) {
			out.println("<tr>");
			out.println("<th>***"+dan+"단"+"***</th>");
			int dann = Integer.parseInt(dan);
			for(int i =1;i<=9;i++) {
				out.println("<tr>");
				out.println("<td>"+dann+"X"+i+"="+dann*i+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
