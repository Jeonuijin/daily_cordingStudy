<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종응답(10_resp_forward-2.jsp)</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pwd");
%>
	<h1>최종응답(10_resp_forward-2.jsp)</h1>
	<h2>아이디 : <%=id %></h2>
	<h2>패스워드 : <%=pw %></h2>
</body>
</html>