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

@WebServlet("/member/doJoin")
public class MemberDoJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberDoJoinServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");
		
		Connection conn = null;
		
	    try {
	    	Class.forName(Config.getDBDriverName());
	    	conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUsr(), Config.getDBPW());
	    	
	    	String loginName = request.getParameter("loginName");
			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			
	    	SecSql sql = new SecSql();
	    	sql.append("SELECT count(id) FROM member");	    	   	
	    	sql.append("WHERE loginId = ?", loginId);	    	   	
	    	int loginIdDupChk = DBUtil.selectRowIntValue(conn, sql);
	    	
	    	if (loginIdDupChk == 1) {
	    		response.getWriter().append(String.format("<script>alert('%s 은 이미 사용중인 아이디 입니다.'); history.back(); </script>", loginId));
		    	return;
	    	} 
	    	
	    	sql = new SecSql();
	    	sql.append("INSERT INTO member");	    	   	
	    	sql.append("SET regDate = NOW()");	    	   	
	    	sql.append(", updateDate = NOW()");	    	   	
	    	sql.append(", loginId = ?", loginId);	    	   	
	    	sql.append(", loginPw = ?", loginPw);	    	   	
	    	sql.append(", `name` = ?", loginName);	    	   	
	    	DBUtil.insert(conn, sql);
	    
	    	response.getWriter().append(String.format("<script>alert('%s 회원님 가입을 축하합니다.'); location.replace('../home/main'); </script>", loginId));
	    	
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















