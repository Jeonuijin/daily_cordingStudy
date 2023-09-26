<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면에 표시 --%>
<% 
String name = request.getParameter("username"); 
String id = request.getParameter("userid"); 
String pwd = request.getParameter("pwd"); 
String pwd2 = request.getParameter("pwd2"); 
String email = request.getParameter("email"); 
String gender = request.getParameter("gender"); 
String[] hobby = request.getParameterValues("hobby");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 데이터</title>
</head>
<body>
	<h1>회원가입 정보(07_resp.jsp)</h1>
	<ul>
		<li>이름 : <%=name %></li>
		<li>비밀번호 : <%=pwd %></li>
		<li>비밀번호 확인 : <%=pwd2 %></li>
		<li>이메일 : <%=email %></li>
		<li>성별 : <%=gender %></li>
		<li>취미 : 
		<%for (int i = 0; i < hobby.length; i++){
			if (i == 0){
				out.println(hobby[i]);
			}else {
				out.println(", " + hobby[i]);
			}
		}%></li>
	</ul>
</body>
</html>