<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 리스트</title>
</head>
<body>
	<h1>전체 책 리스트</h1>
    <table border="1">
        <tr>
            <th>책이름</th>
            <th>가격</th>
            <th>출판사</th>
            <th>작가</th>
            <th>책설명</th>
            <th>책이미지</th>
            <th>카테고리</th>
        </tr>
        <c:forEach var="vo" items="${list}">
            <tr>
            	<td>${vo.category}</td>
                <td><a href="bookUpdate.jsp?bookId=${vo.bookId}">${vo.bookName}</a></td>
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