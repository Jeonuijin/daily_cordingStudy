<%@page import="com.project.model.dao.adminBookDAO"%>
<%@page import="com.project.model.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책정보 수정</title>
</head>

<body>
	<h2>책정보 수정페이지</h2>
	<hr>
	<form action="bookUpdate" method="post" enctype="multipart/form-data">
		<c:forEach var="vo" items="${list }">
			<table>
				<tr>
					<td><label for="booId">책아이디:</label></td>
					<td><input type="text" id="bookName" name="bookId"
						value="${vo.bookId }" required readonly
						style="border: none; outline: none;"></td>
				</tr>
				<tr>
					<td><label for="bookName">책 이름:</label></td>
					<td><input type="text" id="bookName" name="bookName"
						value="${vo.bookName }" required></td>
				</tr>
				<tr>
					<td><label for="price">가격:</label></td>
					<td><input type="number" id="price" name="price"
						value="${vo.price }" required></td>
				</tr>
				<tr>
					<td><label for="publisher">출판사:</label></td>
					<td><input type="text" id="publisher" name="publisher"
						value="${vo.publisher }" required></td>
				</tr>
				<tr>
					<td><label for="pubDate">출판일:</label></td>
					<td><input type="Date" id="pubDate" name="pubDate"
						value="${vo.pubDate }" required></td>
				</tr>
				<tr>
					<td><label for="author">저자:</label></td>
					<td><input type="text" id="author" name="author"
						value="${vo.author }" required></td>
				</tr>
				<tr>
					<td><label for="gradeAvg">평균평점:</label></td>
					<td><input type="text" id="bookName" name="gradeAvg"
						value="${vo.gradeAvg }" required readonly
						style="border: none; outline: none;"></td>
				</tr>
				<tr>
					<td><label for="bookCnt">재고 수량:</label></td>
					<td><input type="number" id="bookCnt" name="bookCnt"
						value="${vo.bookCnt }" required></td>
				</tr>
				<tr>
					<td><label for="orderCnt">주문수량:</label></td>
					<td><input type="text" id="bookName" name="orderCnt"
						value="${vo.orderCnt }" required readonly
						style="border: none; outline: none;"></td>
				</tr>
				<tr>
					<td><label for="details">상세 정보:</label></td>
					<td><textarea id="details" name="details" rows="8"
							value="${vo.details }" required>${vo.details }</textarea></td>
				</tr>
				<tr>
					<td><label for="bookImage">책 이미지:</label></td>
					<td><input type="file" id="bookImage" name="bookImage"
						accept="${vo.bookImage }" required></td>
				</tr>
				<tr>
					<td><label for="category">카테고리:</label></td>
					<td><input type="text" id="category" name="category"
						value="${vo.category }" required></td>
				</tr>
			</table>
		</c:forEach>
		<input type="submit" value="수정"> <input type="reset"
			value="초기화"> <input type="button" value="뒤로가기"
			onclick="history.back()">
	</form>
	</div>
</body>
</html>