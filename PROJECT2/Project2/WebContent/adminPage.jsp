<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록, 수정, 삭제</title>
<script>
	function book_insert() {
		location.href = "bookInsert.jsp";
	}
	function book_update() {
		location.href = "controller?type=update";
	}
	function book_delete() {
		location.href = "controller?type=delete";
	}
</script>
</head>
<body>
	<button onclick="book_insert()">상품등록</button>
	<button onclick="book_update()">상품정보수정</button>
	<button onclick="book_delete()">상품삭제</button>
</body>
</html>