<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="fileUpload" value="${fileUpload}" />
<title>상품등록, 수정, 삭제</title>
<script>
	/* var fileUploadResult = 0;
	fileUpladResult = ${fileUpload};

	if (fileUploadResult > 0) {
   	 	alert("책 등록 완료");
	} else {
  		alert("책 등록 실패");
	} */
	
	
	function book_view() {
		location.href = "bookList";
	}
	
	
	function book_view() {
		location.href = "bookList";
	}
	
	
</script>
</head>
<body>
	<button onclick="book_view()">전체 책 리스트 조회</button>

</body>
</html>