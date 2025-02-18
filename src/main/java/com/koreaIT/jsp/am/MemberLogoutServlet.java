package com.koreaIT.jsp.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

@WebServlet("/member/doLogin")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");

		Connection conn = null;

		try {
			Class.forName(Config.getDBDriverName());
			conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUsr(), Config.getDBPW());

			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");

			SecSql sql = new SecSql();
			sql.append("SELECT * FROM member");
			sql.append("WHERE loginId = ?", loginId);
			Map<String, Object> memberMap = DBUtil.selectRow(conn, sql);
			
			if (memberMap.isEmpty()) {
				response.getWriter().append(String.format("<script>alert('%s 는 존재하지 않는 아이디 입니다.'); location.replace('login'); </script>", loginId));
				return;
			}
			
			if (memberMap.get("loginPw").equals(loginPw) == false) {
				response.getWriter().append(String.format("<script>alert('%s 비밀번호가 일치하지 않습니다.'); location.replace('login'); </script>", loginId));
				return;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("loginedMemberId", memberMap.get("id"));
			session.setAttribute("loginedMemberLoginId", memberMap.get("loginId"));
			
//				session.getAttribute("loginUser");
			response.getWriter().append("<script>alert('로그인 되었습니다.'); location.replace('../home/main'); </script>");


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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
