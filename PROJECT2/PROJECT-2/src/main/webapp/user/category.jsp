<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head> 
<meta charset="UTF-8">
<title>카테고리 별 검색</title>
</head>
<body>
	<h1>카테고리별 도서 검색</h1>

	<!-- 베스트 도서 버튼 -->
	<form action="bestListCategory.jsp" method="get">
		<input type="hidden" name="category" value="best">
		<button type="submit">베스트 도서</button>
	</form>

	<!-- 신간 도서 버튼 -->
	<form action="newtListCategory.jsp" method="get">
		<input type="hidden" name="category" value="new">
		<button type="submit">신간 도서</button>
	</form>
</body>
</html>