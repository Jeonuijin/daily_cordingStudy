<%@page import="com.mystudy.mybatis.GuestbookVO"%>
<%@page import="javax.websocket.Session"%>
<%@page import="com.mystudy.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--전달받은 데이터를 사용해서 DB데이터 삭제(DELETE) 후 화면전환 
	비교값 : 전달받은 pwd 파라미터 값과 session에 저장된 guestbookVO pwd값 비교
	- 일치하면 : DB 삭제 후 목록페이지로 이동
	- 불일치면 : 이전페이지(삭제화면) 이동 - 암호 재입력 할 수 있도록
	삭제성공 : 전체목록 페이지로 이동
	예외발생 : 예외 메시지 표시 후 이전화면(삭제페이지) 또는 상세페이지로 이동처리
--%>
<%
	//0.한글처리
	request.setCharacterEncoding("UTF-8");
	//1. 전달받은 파라미터 값 확인(추출) 후 암호 일치여부 확인
	String pwd = request.getParameter("pwd");
	System.out.println(">delete_ok.jsp pwd : " +pwd);
	
	//1-2 전달받은 session 데이터(VO)확인
	GuestbookVO vo = (GuestbookVO)session.getAttribute("guestbookVO");
	System.out.println(">delete_ok.jsp vo.getPwd() : " + vo.getPwd());
	
	//2. 암호 일치여부 확인 후 DB 연동 작업(삭제)
	int result = -999; //기본값 암호 불일치(-999) 의미
	if (pwd.equals(vo.getPwd())) {
		System.out.println("::: 암호일치~~~ 삭제작업 진행합니다");
		//DB데이터 삭제처리
		result = delete(vo.getIdx());
	}	
	//3. 화면전환(페이지 변경)
%> 
<%!
	//메소드만들기
	private int delete(int idx) {
		int result = 0;
		//DB데이터 삭제처리
		//SqlSession ss = DBService.getFactory().openSession(true); //오토커밋 상태
		SqlSession ss = DBService.getFactory().openSession(); //오토커밋 해제상태
		
		try {
			result = ss.delete("guestbook.delete", idx);
			ss.commit(); //명시적 커밋 처리
			System.out.println(">>정상실행 삭제건수 result : " + result);
		} catch (Exception e) {
			result = -1;  
			ss.rollback(); //명시적 롤백처리 sql문 중 하나라도 오류가 있을경우 롤백
			System.out.println(">>예외발생 result : " + result);
			e.printStackTrace();
		} finally {
			System.out.println(">>>> finally 구문 실행");
			ss.close();
		}
	
		return result;
		}
		

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제진행결과</title>
<script>
	let result = <%=result%>;
	
	if (result == -999){  //java에서는 equal사용, script에서는 ==사용
		alert("암호 불일치, 이전페이지로 이동(delete.jsp)");
		history.back();  //delete.jsp
	}
	if (result == -1) { //예외발생시
		alert("[예외발생] 삭제실패. 담당자문의(8282)\n"
				+ "상세페이지로이동(onelist.jsp)");	
		//history.go(-2);
		//location.href = "onelist.jsp?idx=${guestbookVO.idx}";	//location.href을 이용해 새로운 창으로 보낼 경우 idx값을 넘겨줘야한다.
		location.href = "onelist.jsp?idx=<%=vo.getIdx() %>";
		
	}
	if (result == 0) {	//정상실행 - 삭제안됨(데이터 없음)
		alert("[삭제실패] 데이터가 없어서 삭제 실패\n"
				+ "목록페이지로이동(list.jsp)");	
		location.href = "list.jsp";
	}
	if (result > 0) { //삭제성공
		alert("삭제성공" + result + "건 삭제되었습니다\n"
				+"목록페이지로이동(list.jsp)");
		location.href = "list.jsp";
	}
</script>
</head>
<body>
</body>
</html>