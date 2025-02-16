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

@WebServlet("/member/loginIdChk")
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
	    	
	    	String memberName = request.getParameter("memberName");
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
	    
	    
	    	SecSql sql = new SecSql();
	    	sql.append("INSERT INTO member");	    	   	
	    	sql.append("SET regDate = NOW()");	    	   	
	    	sql.append(", updateDate = NOW()");	    	   	
	    	sql.append(", loginId = ?", memberId);	    	   	
	    	sql.append(", loginPw = ?", memberPw);	    	   	
	    	sql.append(", `name` = ?", memberName);	    	   	
	    
	    	int id = DBUtil.insert(conn, sql);
	    
	    	response.getWriter().append(String.format("<script>alert('%s 회원님 가입을 축하합니다.'); location.replace('../home/main'); </script>", memberName));
	    	
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
