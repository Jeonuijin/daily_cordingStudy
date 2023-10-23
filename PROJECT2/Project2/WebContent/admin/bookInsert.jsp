<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책(상품)등록 페이지</title>
</head>
<body>
	<h2>상품 등록</h2>
	<form action="InsertBook" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><label for="bookName">책 이름:</label></td>
				<td><input type="text" id="bookName" name="bookName" required></td>
			</tr>
			<tr>
				<td><label for="price">가격:</label></td>
				<td><input type="number" id="price" name="price" required></td>
			</tr>
			<tr>
				<td><label for="publisher">출판사:</label></td>
				<td><input type="text" id="publisher" name="publisher" required></td>
			</tr>
			<tr>
				<td><label for="pubDate">출판일:</label></td>
				<td><input type="Date" id="pubDate" name="pubDate" required></td>
			</tr>
			<tr>
				<td><label for="author">저자:</label></td>
				<td><input type="text" id="author" name="author" required></td>
			</tr>
			<tr>
				<td><label for="gradeAvg">평균 평점:</label></td>
				<td><input type="text" id="gradeAvg" name="gradeAvg" required></td>
			</tr>
			<tr>
				<td><label for="bookCnt">재고 수량:</label></td>
				<td><input type="number" id="bookCnt" name="bookCnt" required></td>
			</tr>
			<tr>
				<td><label for="orderCnt">주문 수량:</label></td>
				<td><input type="number" id="orderCnt" name="orderCnt" required></td>
			</tr>
			<tr>
				<td><label for="details">상세 정보:</label></td>
				<td><textarea id="details" name="details" rows="8" required></textarea></td>
			</tr>
			<tr>
				<td><label for="bookImage">책 이미지:</label></td>
				<td><input type="file" id="bookImage" name="bookImage"
					required></td>
			</tr>
			<tr>
				<td><label for="category">카테고리:</label></td>
				<td><input type="text" id="category" name="category" required></td>
			</tr>
		</table>
		<input type="submit" value="등록"> <input type="reset"
			value="초기화">
	</form>
</body>
</html>