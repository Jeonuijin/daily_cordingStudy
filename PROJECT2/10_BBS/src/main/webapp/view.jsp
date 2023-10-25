<%@page import="com.mystudy.bbs.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="com.mystudy.bbs.vo.BbsVO"%>
<%@page import="com.mystudy.bbs.dao.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 전달받은 파라미터 값(bbsIdx) 사용 DB데이터 조회 화면표시
	1. 게시글 조회수 1 증가(실습)
	2. 게시글(bbsIdx) 데이터 조회 후 화면 표시
	3. 게시글(bbsIdx)에 딸린 댓글이 있으면 조회 후 화면 표시
--%>
<%
	//파일미터 값 추출(확인)
	int bbsIdx = Integer.parseInt(request.getParameter("bbsIdx"));
	String cPage = request.getParameter("cPage");
	
	//1. 게시글 조회수 1 증가(실습)
	BbsDAO.hitAdd(bbsIdx);
	
	//2. 게시글(bbsIdx) 데이터 조회 후 화면 표시
	BbsVO bvo = BbsDAO.selectOne(bbsIdx);
	System.out.println("bvo : " + bvo);
	
	//3. 게시글(bbsIdx)에 딸린 댓글이 있으면 조회 후 화면 표시
	List<CommentVO> commList = BbsDAO.getCommList(bbsIdx);
	System.out.println("commList : " + commList);
	
	//page에 등록
	pageContext.setAttribute("bvo", bvo);
	pageContext.setAttribute("commList", commList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물</title>
<style>
	#hitCount {
		font-size: 14px;
		text-align: right;
	}
	#view table {
		width: 580px;
		margin-left: 10px;
		border-collapse: collapse;
		font-size: 14px;
	}
	#caption1 {
		font-size: 20px;
		font-weight: bold;
		margin-bottom: 10px;
	}
	#view th, #view td {
		border: 1px solid black;
		padding: 4px 10px;
		text-align: center;
	}
	#view th {
		background-color: lightgrey;
	}
	#writer { width: 20%; }
	#content { height: 200px; }
	#cWriter {text-align: left;}
</style>
</head>
<body>
	<div id="view">
	<table style="border: 1px solid black;">
	<caption id = caption1>게시글목록</caption>
	<caption id = hitCount>조회수 : ${bvo.hit }</caption>
		<tbody>
		<tr>
				<th id = writer>작성자</th>
				<td>${bvo.writer }</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${bvo.subject }</td>
			</tr>
			<tr>
				<th  colspan="2">내용</th>
			</tr>
			<tr>
				<td id = content colspan="2">${bvo.content }</td>
			</tr>
		</tbody>
		<tfoot>
	<c:choose>
		<c:when test="${empty commList }">
			<tr>
				<td colspan="2">
					<h2>현재 등록된 댓글이 없습니다</h2>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
				<tr>
					<th colspan="2">댓글보기</th>
				</tr>
			<c:forEach var="comm" items="${commList }">	
				<tr>
					<th id = cWriter>${comm.writer }</th>
					<td>${comm.content }</td>
				</tr>

			</c:forEach>
		</c:otherwise>
		</c:choose>
		</tfoot>
		</table>
		</div>
</body>
</html>