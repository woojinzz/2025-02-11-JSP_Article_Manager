package com.koreaIT.jsp.am;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/article/write")
public class ArticleWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginedMemberId") == null) {
			response.setContentType("text/html; charset=UTF-8;");
			response.getWriter().append("<script>alert('먼저 로그인을 해주세요'); location.replace('../member/login'); </script>");
			return;
		}
		
		request.getRequestDispatcher("/jsp/article/write.jsp").forward(request, response);
		
		
		
	}
}










