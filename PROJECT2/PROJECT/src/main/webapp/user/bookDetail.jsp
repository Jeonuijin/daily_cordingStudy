<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세정보</title>
</head>
<body>
<h2>책 상세정보</h2>
<c:forEach var="vo" items="${list}">
				<tr>

					<td>${vo.category}</td>
					<td>${vo.bookName}</td>
					<td>${vo.price}</td>
					<td>${vo.publisher}</td>
					<td>${vo.author}</td>
					<td>${vo.details}</td>
					<td>${vo.bookImage}</td>
				</tr>
			</c:forEach>
			<hr>
			<h3>-- 리뷰 --</h3>
				<%--게시글에 대한 댓글 작성 영역--%>
	<form action="ans_write_ok.jsp" method="get">
		<p>
			작성자 : <input type="text" name="writer">
			비밀번호 : <input type="password" name="pwd">
		</p>
		<p>내용 : <textarea name="content" rows="4" cols="55"></textarea></p>
		<input type="submit" value="댓글저장">
		<input type="hidden" name="bbsIdx" value="${bvo.bbsIdx }">
	</form>
	<hr>
	
	<%--게시글에 딸린 댓글 표시 영역 --%>
	<%-- <c:forEach var="commVO" items="${c_list }">
	<div class="comment">
		<form action="ans_del.jsp" method="post">
			<p>작성자: ${commVO.writer } &nbsp;&nbsp; 작성일: ${commVO.writeDate }</p>
			<p>내용 : ${commVO.content }</p>
			<input type="submit" value="댓글삭제">
			<input type="hidden" name="commentIdx" value="${commVO.commentIdx }"> --%>
			
			<!--댓글 삭제 후 게시글 상세페이지로 이동시 사용할 데이터 처리
				세션에 게시글데이터, 페이지번호가 없으면 명시적으로 데이터 넘기기-->
			<%-- <input type="hidden" name="bbsIdx" value="${commVO.bbsIdx }">
			<input type="hidden" name="cPage" value="${cPage }"> --%>
		</form>
	</div>
</body>
</html>