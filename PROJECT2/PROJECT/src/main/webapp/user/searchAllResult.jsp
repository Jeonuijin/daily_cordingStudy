<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합검색결과</title>
</head>
<body>
	<h2>통합검색결과</h2>
	<table border="1">
		<tr>
			<th>카테고리</th>
			<th>책이름</th>
			<th>가격</th>
			<th>출판사</th>
			<th>작가</th>
			<th>책설명</th>
			<th>책이미지</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.category}</td>
				<td><a href="bookListOne?bookId=${vo.bookId}">${vo.bookName}</td>
				<td>${vo.price}</td>
				<td>${vo.publisher}</td>
				<td>${vo.author}</td>
				<td>${vo.details}</td>
				<td>${vo.bookImage}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>