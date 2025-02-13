<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, java.util.ArrayList" %>
    
<%
	List<Map<String, Object>> articleListMap = (List<Map<String, Object>>) request.getAttribute("articleListMap");
	int from = (int) request.getAttribute("from"); 
	int end = (int) request.getAttribute("end"); 
	int totalPages = (int) request.getAttribute("totalPages"); 
	int currentPage = (int) request.getAttribute("currentPage"); 
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
<body>
	<div>
		<a href="<%= request.getContextPath() %>/home/main">메인</a>
	</div>
	<div>
		<h2>리스트</h2>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th> 
					<th>날짜</th> 
					<th>제목</th> 
				</tr>
			</thead>
			<tbody>
				<% 
				for (Map<String,Object> article : articleListMap) { 
				%>
				<tr>
					<td><%= article.get("id") %></td>
					<td><%= article.get("updateDate") %></td>
					<td><a href="detail?id=<%= article.get("id") %>" > <%= article.get("title") %></a></td>
				</tr>
				<% 
				}
				%>
			</tbody>
		</table>
		
		<style type="text/css">
			.red {
				color: red;
				font-size : 1.5rem;
			}
		</style>
		
		<div>
		
			<%
			if (from != 1) {
			%>	
				<a href="?page=1">&lt&lt</a>
				<a href="?page=<%= from - 1 %>">◀</a>
			<%
			}
			%>

			
			<% 
			if (totalPages <= end) {
				end = totalPages;
			} 
			%>
			<% 
			for (int i = from; i <= end; i++) { 
			%>
				<a class=" <%= currentPage == i ? "red" : "" %>" href="?page=<%= i %>"><%= i %></a>
			<% 
			}
			%>
			
			<%
			if (end != totalPages) {
			%>
			
			<a href="?page=<%= end + 1 %>">▶</a>
			<a href="?page=<%= totalPages %>">&gt&gt</a>
			
			<% 
			} 
			%>
			
		
		</div>
	</div>
</body>
</html>

