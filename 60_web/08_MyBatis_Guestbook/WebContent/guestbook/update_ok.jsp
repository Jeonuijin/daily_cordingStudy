<%@page import="com.mystudy.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받으 데이터 사용 DB데이터 수정(UPDATE) 처리 후 화면전환
	수정성공 : 상세화면으로 이동(또는 전체목록페이지로 이동)
	예외발생 : 예외메시지 표시 후 이전화면(수정페이지) 이동
--%>
<%
	//0.한글처리
	request.setCharacterEncoding("UTF-8");
	//1. 파라미터 값 확인(추출) - VO에 저장
%> 
	<jsp:useBean id="vo" class="com.mystudy.mybatis.GuestbookVO"/>
	<jsp:setProperty property="*" name="vo"/>
<%
	System.out.println("> update_ok.jsp vo : " + vo);

	//2. DB데이터 수정처리(SqlSession 객체 사용 DB UPDATE)
	SqlSession ss = DBService.getFactory().openSession(true);
	
	//3. 화면전환

	//2-2 SqlSession 객체 사용 DB에 입력
	try {
		ss.update("guestbook.update", vo);
%>
	<script>
		//alert("정상 수정되었습니다.\목록 페이지로 이동합니다.")
		//location.href = "list.jsp"; 	//수정완료시 alert을 띄우고 싶으면 script에서 페이지전환을 해야함.
										// Java코드로 페이지 전환 시 alert창 못띄움
	</script>

<%
	//3. 페이지 전환 : 입력 성공시 페이지 이동(전환)
	//response.sendRedirect("list.jsp");
	response.sendRedirect("onelist.jsp?idx=" + vo.getIdx());  //상세페이지로 보내기 위해서는 idx값을 넘겨줘야 한다.
	} catch (Exception e) {
		System.out.println(">>[예외발생]입력실패");
		e.printStackTrace();
	}finally {
		ss.close();	
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
<script>
		alert("[예외발생] 수정작업중 오류발생\n"
					+ "이전 페이지로 이동합니다.");
		//history.back(); //이전페이지(수정화면)
		history.go(-2); //상세화면으로 이동(전전페이지)
</script>
</head>
<body>

</body>
</html>