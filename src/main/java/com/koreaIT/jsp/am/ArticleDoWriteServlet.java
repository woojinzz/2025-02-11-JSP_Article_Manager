package com.koreaIT.jsp.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.koreaIT.jsp.am.util.DBUtil;
import com.koreaIT.jsp.am.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doWrite")
public class ArticleDoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArticleDoWriteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");
//		response.getWriter().append(String.format("제목은 %s", title));
		
		final String URL = "jdbc:mysql://localhost:3306/jsp_am?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull"; // DB
		final String USER = "root"; // 3DB 사용자 이름
		final String PASSWORD = "qwer"; // DB 비밀번호
		
		Connection conn = null;
		
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	conn = DriverManager.getConnection(URL, USER, PASSWORD);
	    	
			String title = request.getParameter("title");
			String body = request.getParameter("body");
	    
	    
	    	SecSql sql = new SecSql();
	    	sql.append("INSERT INTO article");	    	   	
	    	sql.append("SET regDate = NOW()");	    	   	
	    	sql.append(", updateDate = NOW()");	    	   	
	    	sql.append(", title = ?", title);	    	   	
	    	sql.append(", body = ?", body);	    	   	
	    
	    	int id = DBUtil.insert(conn, sql);
	    
	    	response.getWriter().append(String.format("<script>alert('%d 번 글을 작성했습니다.'); location.replace('list'); </script>", id));
	    	
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
