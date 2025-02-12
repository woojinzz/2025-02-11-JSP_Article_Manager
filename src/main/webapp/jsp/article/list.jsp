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
		<ul>
		<% for (Map<String,Object> article : articleListMap) { %>
			<li><%= article.get("id") %> | <%= article.get("updateDate") %> | <a href="detail?id=<%= article.get("id") %>" > <%= article.get("title") %></a></li>
			
		<% 	}  %>
		
		</ul>
	</div>
	


</body>
</html>