<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach varStatus</title>
</head>
<body>
<%
	List<String> list = new ArrayList<>();
	list.add("홍길동1");
	list.add("홍길동2");
	list.add("홍길동3");
	list.add("홍길동4");
	System.out.println("> list : " + list);
	System.out.println("> list.size() : " + list.size());
	pageContext.setAttribute("alist", list);
%>
	<h2>forEach List 데이터 표시</h2>
	<c:forEach var="listData" items="${alist }">
		${listData }
	</c:forEach>
	<hr>
	
	<h2>forEach varStatus 사용</h2>
	<ol>
	<c:forEach var="listData" items="${alist }" varStatus="status">
		<li>
			status : ${status }	<br>
			데이터 : ${status.current }<br>		    <%--현재 처리중인 데이터 --%>
			status.count : ${status.count }<br>	    <%--처리되는 데이터 건수 --%>
			status.index : ${status.index }<br>		<%-- 인덱스번호 --%>
			status.first : ${status.first }<br>		<%--지금 처리되는 데이터가 첫번째냐? --%>
			status.last : ${status.last }<br>		<%--지금 처리되는 데이터가 마지막이냐? --%>
			
			status.begin : ${status.begin }<br>
			status.end : ${status.end }<br>
			status.step : ${status.step }<br>
		</li>
	</c:forEach>
	</ol>
	<hr>
	
	<ul>
	<c:forEach var="listData" items="${alist }" varStatus="status"
		begin="2" end="${alist.size()-1 }" step="1">
		<li>
			status : ${status }	<br>
			데이터 : ${status.current }<br>		    <%--현재 처리중인 데이터 --%>
			status.count : ${status.count }<br>	    <%--처리되는 데이터 건수 --%>
			status.index : ${status.index }<br>		<%-- 인덱스번호 --%>
			status.first : ${status.first }<br>		<%--지금 처리되는 데이터가 첫번째냐? --%>
			status.last : ${status.last }<br>		<%--지금 처리되는 데이터가 마지막이냐? --%>
			
			status.begin : ${status.begin }<br>
			status.end : ${status.end }<br>
			status.step : ${status.step }<br>
		</li>
	</c:forEach>
	</ul>
</body>
</html>