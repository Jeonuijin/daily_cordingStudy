<%@page import="com.mystudy.common.JdbcUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--(실습) 전달받은 데이터로 DB데이터를 수정처리 후 페이지 전환 
	수정할데이터 : 성명, 금액, 날짜(SYSDATE)
	정상처리 후 : list.jsp 또는 detail.jsp 페이지 이동 처리	
	예외발생시 : 현재 페이지에 오류메시지 보여주기
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
</head>
<body>
	<%
	//1. 전달받은 데이터 확인
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	String name = request.getParameter("name");
	
	int pay = 0;
	String sPay = request.getParameter("pay");
	System.out.println("Param pay : " + sPay);
	try {
		pay = Integer.parseInt(sPay);
	}catch(NumberFormatException e){		//pay값에 숫자가아닌 문자가 들어갈 경우
%>
		<script>	
			alert("금액에 숫자가 아닌 값이 입력되었습니다.\n" +"확인후 다시입력하세요");
			history.back();
		</script>
<% 	
		return; //service()메소드 종료
	}
	
	//2. DB데이터 수정
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//실행결과에 대한 처리 변수
	int result = 0;
	
	try {
		//1. JDBC 드라이버 로딩
		Class.forName(JdbcUtil.DRIVER);
				
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		conn = JdbcUtil.getConnection();
		
		//3. Statement 문 실행(SQL 문 실행)
		//3-1. SQL문 준비
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE EMPLOYEE SET ");
		sql.append(" NAME = ?, PAY = ? ");
		//sql.append(" , REGDATE = SYSDATE ");
		sql.append("WHERE SABUN = ?");
				
		pstmt = conn.prepareStatement(sql.toString());
				
		//3-2. 바인드변수(매개변수, 파라미터) 값 설정
		//pstmt.setInt(1, Integer.parseInt(sabun));
		pstmt.setString(1, name);
		pstmt.setInt(2, pay);
		pstmt.setInt(3, sabun);
				
		//4. SQL 실행 결과에 대한 처리
		//4-1. SQL문 실행
		result = pstmt.executeUpdate();
		System.out.println("건수 : " + result);	
	} catch(Exception e) {
		e.printStackTrace();
		result = -1;    	//오류가 있는 케이스일경우, result값을 -1로 설정하기
	} finally {
		//5. 클로징 처리에 의한 자원 반납
		JdbcUtil.close(conn, pstmt, rs);
	}
		//4-2. SQL 실행결과에 대한 처리
		if (result > 0) {			//성공적으로 수정한 값 : 1
%>
			<script>	
				alert("정보수정 성공")
				location.href = "list.jsp"; 
			</script>
<% 
		}
		if (result == 0) {		//SQL문 정상실행 + 데이터 없음 : 0
%>
			<script>	
				alert("정보수정 실패!! 대상이 없습니다\n"+"목록으로 돌아갑니다.")
				location.href = "list.jsp"; 
			</script>
<% 	
		}
%>
	<h1>[오류]사원수정 실패</h1>
	<p>수정을 하지 못했습니다</p>
	담당자에게 연락하세요
	
	<a href="detail.jsp?sabun=<%=sabun%>">상세페이지로이동</a>
	<a href="list.jsp">전체목록 보기</a>
</body>
</html>