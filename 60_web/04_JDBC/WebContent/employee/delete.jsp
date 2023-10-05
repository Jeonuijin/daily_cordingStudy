<%@page import="com.mystudy.common.JdbcUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int sabun = Integer.parseInt(request.getParameter("sabun"));

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		//1. JDBC 드라이버 로딩
		Class.forName(JdbcUtil.DRIVER);
				
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		conn = JdbcUtil.getConnection();
		
		//3. Statement 문 실행(SQL 문 실행)
		//3-1. SQL문 준비
		String sql = "";
		sql = "DELETE FROM EMPLOYEE WHERE SABUN = ? ";
				
		pstmt = conn.prepareStatement(sql.toString());
				
		//3-2. 바인드변수(매개변수, 파라미터) 값 설정
		//pstmt.setInt(1, Integer.parseInt(sabun));
		pstmt.setInt(1, sabun);
				
		//4. SQL 실행 결과에 대한 처리
		//4-1. SQL문 실행
		int result = pstmt.executeUpdate();
		System.out.println("건수 : " + result);
				
		//4-2. SQL 실행결과에 대한 처리
		if (result > 0) {
			response.sendRedirect("list.jsp");
		}
			
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
	//5. 클로징 처리에 의한 자원 반납
		JdbcUtil.close(conn, pstmt, rs);
	}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제실패</title>
	<h2>삭제실패!! 관리자에게 문의하세요</h2>
</head>
<body>

</body>
</html>