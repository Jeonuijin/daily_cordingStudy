
<%@page import="com.project.model.vo.BookVO"%>
<%@page import="com.project.model.vo.BbsVO"%>
<%@page import="com.project.model.dao.adminBookDAO"%>
<%@page import="com.project.model.common.Paging"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
Integer datasize = (Integer) request.getAttribute("size");
System.out.println("Received parameter: " + datasize);
System.out.println("search : " + request.getAttribute("search"));

System.out.println("list222 : " + request.getAttribute("list")); %>
 
<%
	//0. 페이징 처리를 위한 객체(Paging) 생성
	Paging p = new Paging();

	//1. 전체 게시물 수량 구하기
	p.setTotalRecord(datasize);
	p.setTotalPage();
	System.out.println("> 전체 게시글 수 : " + p.getTotalRecord());
	System.out.println("> 전체 페이지 수 : " + p.getTotalPage());
	
	//2. 현재 페이지 구하기
	String cPage = request.getParameter("cPage");
	if (cPage != null) {
		p.setNowPage(Integer.parseInt(cPage));
	}
	System.out.println("> cPage : " + cPage);
	System.out.println("> paging nowPage : " + p.getNowPage());
	
	//3. 현재 페이지에 표시할 게시글 시작번호(begin), 끝번호 구하지
	p.setEnd(p.getNowPage() * p.getNumPerPage());
	p.setBegin(p.getEnd() - p.getNumPerPage() + 1);
	
	//3-1. (선택적) 끝 번호가 데이터 건수보다 많아지면 데이터 건수와 동일하게 설정
	if (p.getEnd() > p.getTotalRecord()) {
		p.setEnd(p.getTotalRecord());
	}
	
	System.out.println(">> 시작번호(begin) : " + p.getBegin());
	System.out.println(">> 끝번호(end) : " + p.getEnd());
	
	//------ 블록(block) 게산하기 -----------------
	//4. 블록 시작페이지, 끝페이지 구하기
	//4-1. 시작페이지 구하기
	int beginPage = (p.getNowPage() - 1) / p.getPagePerBlock() * p.getPagePerBlock() + 1;
	p.setBeginPage(beginPage);
	p.setEndPage(beginPage + p.getPagePerBlock() -1);
	
	//4-2. 끝페이지(endPage)가 전체 페이지 수(totalPage) 보다 크면
	// 끝페이지를 전체 페이지 수로 변경처리(설정)
	if (p.getEndPage() > p.getTotalPage()) {
		p.setEndPage(p.getTotalPage());
	}
	
	System.out.println(">> 시작페이지(beginPage) : " + p.getBeginPage());
	System.out.println(">> 끝페이지(endPage) : " + p.getEndPage());
	
	System.out.println("p : " + p);
%>
<%

	//검색 결과를 데이터베이스 또는 다른 소스에서 가져옴
	List<BookVO> searchData = (List<BookVO>)request.getAttribute("list");
	
	List<BookVO> list = searchData.subList(p.getBegin(), p.getEnd()+1);
	
	System.out.println("리스트 : " + list);
	// 현재 페이지에 해당하는 데이터만 추출
	//List<YourDataClass> currentPageData = searchData.subList(begin, end);
	//================================
	//현재 페이지 기준으로 DB데이터(게시글) 가져오기
	//시작번호(begin), 끝번호(end) 사용해서
	//List<BbsVO> list = adminBookDAO.getPageList(p.getBegin(), p.getEnd());
	//System.out.println(">> 현재 페이지 글목록(list) : " + list);
	
	//--------------------------
	//JSTL, EL 사용을 위해 scope에 데이터 등록(page 영역)
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("pvo", p);
	
	//(개인적실습) 현재 페이지번호 사용 블록번호 구하고, 블록번호로 시작/끝 페이지 구하기
	System.out.println("p : " + p);	
%> 
<!DOCTYPE html>
<script>
    function goBack() {
        location.href = "userSearchAll.jsp"; // userSearchAll.jsp 페이지로 이동
    }
</script>
<html>
<head>
    <meta charset="UTF-8">
    <title>통합검색결과</title>
</head>
<body>
    <h2>통합검색결과</h2>
   
    <c:choose>
        <c:when test="${empty list}">
        	 
            <p>"${list }"에 대한 검색 결과가 없습니다.</p>
            <button onclick="goBack()">검색창으로 돌아가기</button>
        </c:when>
        <c:otherwise>
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
                        <td><a href="searchAll?search=${search}?bookId=${vo.bookId}">${vo.bookName}</a></td>
                        <td>${vo.price}</td>
                        <td>${vo.publisher}</td>
                        <td>${vo.author}</td>
                        <td>${vo.details}</td>
                        <td><img src="<c:url value='/upload/${vo.bookImage}' />" alt="Image"></td>
                    </tr>
                </c:forEach>
                <tfoot>
			<tr>
				<td colspan="4">
					<ol class="paging">
					<%--[이전으로]에 대한 사용여부 처리 --%>
					<c:if test="${pvo.beginPage == 1 }">
						<li class="disable">이전으로</li>
					</c:if>
					<c:if test="${pvo.beginPage != 1 }">
						<li>
							<a href="searchAll?search=${search}&?cPage=${pvo.beginPage - 1 }">이전으로</a>
						</li>
					</c:if>	
					
					<%--블록내에 표시할 페이지 태그 작성(시작페이지~끝페이지) --%>
					<c:forEach var="pageNo" begin="${pvo.beginPage }" end="${pvo.endPage }">
					<c:if test="${pageNo == pvo.nowPage }">
						<li class="now">${pageNo }</li>
					</c:if>	
					<c:if test="${pageNo != pvo.nowPage }">
						<li>
							<a href="searchAll?search=${search}&?cPage=${pageNo }">${pageNo }</a>
						</li>
					</c:if>		
						
					</c:forEach>
					
					<%--[다음으로]에 대한 사용여부 처리 --%>
					<c:if test="${pvo.endPage >= pvo.totalPage }">
						<li class="disable">다음으로</li>
					</c:if>
					<c:if test="${pvo.endPage < pvo.totalPage }">
						<li>
							<a href="searchAllResult.jsp?cPage=${pvo.endPage + 1 }">다음으로</a>
						</li>
					</c:if>		 
					</ol>
				
				</td>

			</tr>
		</tfoot>
            </table>
            <button onclick="goBack()">검색창으로 돌아가기</button>
        </c:otherwise>
    </c:choose>
</body>
</html>