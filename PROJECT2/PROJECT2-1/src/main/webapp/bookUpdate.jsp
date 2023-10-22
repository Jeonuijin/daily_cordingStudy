<%@page import="com.project.model.dao.adminBookDAO"%>
<%@page import="com.project.model.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	//전달받은 파라미터값 확인
	String bookId = request.getParameter("bookId");
	
	out.println("bookId: " + bookId); 
	
	//2. DB에서 해당부서(deptno)에 있는 직원 조회(DAO사용)
	List<BookVO> list = adminBookDAO.selectBookId(bookId);
	
	//3. 조회된 데이터를 응답페이지(deptList.jsp)에서 사용토록 scope에 저장
	//out.println("bookId로 찾은 책 정보: " + list); 
	
	
	
	
	%>
<title>책정보 수정</title>
</head>

<body>
	<h2>책정보 수정페이지</h2>
	<hr>
	
	<form action="bookUpdate" method="post" enctype="multipart/form-data">
        <table>
        	<tr>
				<th>책아이디:</th>
				<td><%= list.get(0).getBookId()%></td>
			</tr>
            <tr>
                <td><label for="bookName">책 이름:</label></td>
                <td><input type="text" id="bookName" name="bookName" value ="<%= list.get(0).getBookName() %>" required readonly style="border: none; outline: none;"></td>
            </tr>
            <tr>
                <td><label for="price">가격:</label></td>
                <td><input type="number" id="price" name="price" value ="<%= list.get(0).getPrice() %>" required></td>
            </tr>
            <tr>
                <td><label for="publisher">출판사:</label></td>
                <td><input type="text" id="publisher" name="publisher" value ="<%= list.get(0).getPublisher()%>" required></td>
            </tr>
            <tr>
                <td><label for="pubDate">출판일:</label></td>
                <td><input type="Date" id="pubDate" name="pubDate" value ="<%= list.get(0).getPubDate()%>" required></td>
            </tr>
            <tr>
                <td><label for="author">저자:</label></td>
                <td><input type="text" id="author" name="author" value ="<%= list.get(0).getAuthor()%>" required></td>
            </tr>
            <tr>
				<th>평균평점:</th>
				<td><%= list.get(0).getGradeAvg()%></td>
			</tr>
            <tr>
                <td><label for="bookCnt">재고 수량:</label></td>
                <td><input type="number" id="bookCnt" name="bookCnt" value ="<%= list.get(0).getBookCnt()%>" required></td>
            </tr>
             <tr>
				<th>주문수량:</th>
				<td><%= list.get(0).getOrderCnt()%></td>
			</tr>
            <tr>
                <td><label for="details">상세 정보:</label></td>
                <td><textarea id="details" name="details" rows="8" value ="<%= list.get(0).getDetails()%>" required><%= list.get(0).getDetails()%></textarea></td>
            </tr>
            <tr>
                <td><label for="bookImage">책 이미지:</label></td>
                <td><input type="file" id="bookImage" name="bookImage" accept="<%= list.get(0).getBookImage()%>" required></td>
            </tr>
            <tr>
                <td><label for="category">카테고리:</label></td>
                <td><input type="text" id="category" name="category" value ="<%= list.get(0).getCategory()%>" required></td>
            </tr>
        </table>
        <input type="submit" value="수정">
        <input type="reset" value="초기화">
        <input type="back" value="뒤로가기">
    </form>
</div>	
</body>
</html>