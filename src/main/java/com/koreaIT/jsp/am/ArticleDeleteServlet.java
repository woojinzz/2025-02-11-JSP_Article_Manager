package com.koreaIT.jsp.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.koreaIT.jsp.am.util.DBUtil;
import com.koreaIT.jsp.am.util.SecSql;
import com.koreaIT.jsp.config.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/delete")
public class ArticleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");

		
		Connection conn = null;
		
	    try {
	    	Class.forName(Config.getDBDriverName());
	    	conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUsr(), Config.getDBPW());
	    	
	    	int id = Integer.parseInt(request.getParameter("id"));
//	    	response.getWriter().append(String.format("<div>== %d==</div>", id));

	    	SecSql sql = new SecSql();
	    	sql.append("DELETE FROM article");
	    	sql.append("WHERE id = ?", id);
	    	
	    	DBUtil.delete(conn, sql);
	    	
	    	response.getWriter().append(String.format("<script>alert('%d 번 글이 삭제되었습니다.'); location.replace('list'); </script>", id));
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			response.getWriter().append(String.format("<div>== 오류==</div>"));
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
