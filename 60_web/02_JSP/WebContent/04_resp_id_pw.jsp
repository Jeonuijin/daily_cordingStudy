<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터(파라미터값)를 화면 출력 --%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw"); 
	//파라미터 값으로 불러오는 값은 클라이언트 서버에서 설정한 name값과 같아야 불러올 수 있다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>응답페이지(04_resp_id_pw.jsp)</h2>
	<h3>(응답)당신이 입력한 데이터가 맞나요?</h3>
	<h2>아이디 : <%=id%></h2>
	<h2>비밀번호 : <%=pw%></h2>
</body>
</html>