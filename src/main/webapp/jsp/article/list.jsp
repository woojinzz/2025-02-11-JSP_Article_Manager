<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap, java.util.ArrayList" %>
    
<%
	List<Map<String, Object>> articleListMap = (List<Map<String, Object>>) request.getAttribute("articleListMap");


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
			<thaed>
				<tr>
					<th>번호</th> 
					<th>날짜</th> 
					<th>제목</th> 
				</tr>
			</thaed>
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
	</div>
</body>
</html>