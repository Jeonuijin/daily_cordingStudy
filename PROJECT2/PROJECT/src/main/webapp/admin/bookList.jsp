<%@page import="java.io.File"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.awt.image.DataBufferDouble"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<script type="text/javascript">
function book_insert() {
	location.href = "bookInsert.jsp";
}
function book_update() {
    var selectedBook = document.querySelector('input[name="selectedBook"]:checked');
    
    if (!selectedBook) {
        alert("수정할 책을 선택하세요.");
    } else {
        // 선택된 책의 bookId 값을 사용하여 수정 페이지로 이동합니다.
    	window.location.href = "bookListOne?bookId=" + selectedBook.value;
    }
}

function book_delete() {
    var selectedBook = document.querySelector('input[name="selectedBook"]:checked');
    
    if (!selectedBook) {
        alert("삭제할 책을 선택하세요.");
    } else {
        // 선택된 책의 bookId 값을 사용하여 삭제 페이지로 이동합니다.
        window.location.href = "bookDelete?bookId=" + selectedBook.value;
    }
}
</script>
<html>
<head>
<meta charset="UTF-8">
<title>책 리스트</title>

</head>
<body>
	<h1>전체 책 리스트</h1>
	<div class="table-container">
		<table border="1">
			<tr>
				<th></th>
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
					<td><input type="radio" name="selectedBook"
						value="${vo.bookId}" /></td>
					<td>${vo.category}</td>
					<td>${vo.bookName}</td>
					<td>${vo.price}</td>
					<td>${vo.publisher}</td>
					<td>${vo.author}</td>
					<td>${vo.details}</td>
					<td>${vo.bookImage}</td>
					<td><img src="/upload/스크린샷 2023-10-02 133118.jpg" alt="Image"></td>
				</tr>
			</c:forEach>
		</table>
		<div class="button-container">
			<button onclick="book_insert()">책 등록</button>
			<button onclick="book_update()">책정보수정</button>
			<button onclick="book_delete()">책삭제</button>
		</div>
	</div>
</body>
</html>