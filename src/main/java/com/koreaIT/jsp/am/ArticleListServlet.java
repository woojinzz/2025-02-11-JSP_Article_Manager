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
import jakarta.servlet.http.HttpSession;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");
		
		Connection conn = null;
		
	    try {
	    	Class.forName(Config.getDBDriverName());
	    	conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUsr(), Config.getDBPW());
	    	
	    	int currentPage = 1;
	    	
	    	if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
	    		currentPage = Integer.parseInt(request.getParameter("page"));
	    	}
	    
	    	int pageSize = 10; /*한 페이지 데이터 수*/
	    	int startRow = (currentPage - 1) * pageSize; /*db 데이터 시작 위치 */
	    	
	    	int from = ((currentPage -1) / pageSize) * 10 + 1;
	    	int end = (((currentPage -1) / pageSize) + 1) * 10 ;
	    	
	    	SecSql sql = new SecSql();
	    	sql.append("SELECT COUNT(id) FROM article");	    	   	
	    	
	    	int totalRocords = DBUtil.selectRowIntValue(conn, sql);
	    	int totalPages = (int) Math.ceil((double) totalRocords / pageSize); 
	    	
	    	sql = new SecSql();
	    	sql.append("SELECT A.*, M.loginId `writerName`");
	    	sql.append("FROM article A");
	    	sql.append("INNER JOIN `member` M");
	    	sql.append("ON A.memberId = M.id");
	    	sql.append("ORDER BY id DESC");
	    	sql.append("LIMIT ?, ?", startRow, pageSize);
	    	   	
	    	List<Map<String, Object>> articleListMap = DBUtil.selectRows(conn, sql);
	    	
			HttpSession session = request.getSession();
			int loginedMemberId = -1;
			

			if (session.getAttribute("loginedMemberId") != null) {
				loginedMemberId = (int) session.getAttribute("loginedMemberId");
			}
		
			request.setAttribute("loginedMemberId", loginedMemberId);
	    	request.setAttribute("from", from);
	    	request.setAttribute("end", end);
	    	request.setAttribute("totalPages", totalPages);
	    	request.setAttribute("currentPage", currentPage);
	    	request.setAttribute("articleListMap", articleListMap);
	    	request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);
	    	
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
	
}
