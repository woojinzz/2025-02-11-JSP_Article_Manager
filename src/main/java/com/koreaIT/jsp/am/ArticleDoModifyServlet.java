package com.koreaIT.jsp.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.koreaIT.jsp.am.util.DBUtil;
import com.koreaIT.jsp.am.util.SecSql;
import com.koreaIT.jsp.config.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doModify")
public class ArticleDoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArticleDoModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");
//		response.getWriter().append(String.format("제목은 %s", title));
		
		
		Connection conn = null;
		
	    try {
	    	Class.forName(Config.getDBDriverName());
	    	conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUsr(), Config.getDBPW());
	    	
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			int id = Integer.parseInt(request.getParameter("id"));
	    
	    	SecSql sql = new SecSql();
	    	sql.append("UPDATE article");	    	   	
	    	sql.append("SET updateDate = NOW()");	    	   	
	    	sql.append(", title = ?", title);	    	   	
	    	sql.append(", body = ?", body);	    	   	
	    	sql.append("WHERE id = ?", id);	    	   	
	   
	    	DBUtil.update(conn, sql);
	    
	    	response.getWriter().append(String.format("<script>alert('%d 번 글을 수정했습니다.'); location.replace('detail?id=%d'); </script>", id, id));
	    	
		} catch (SQLException e) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
