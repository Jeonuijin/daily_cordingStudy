<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%-- 전달받은 데이터를 사용해서 계산처리 후 결과를 테이블 형태로 작성 
   데이터 처리 : 스트립트릿(<% %>)
   데이터 출력 : 표현식(<%= %>) --%>
<%
	//1. 전달받은 데이터(파라미터)값 추출(확인)
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor")); 
	int eng = Integer.parseInt(request.getParameter("eng")); 
	int math = Integer.parseInt(request.getParameter("math")); 
	
	//2. 계산처리 : 총점, 평균 구하기
	int tot = kor + eng + math;
	double avg = tot * 100 / 3 / 100.0;
	//파라미터 값으로 불러오는 값은 클라이언트 서버에서 설정한 name값과 같아야 불러올 수 있다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적처리결과</title>
<style>
	table { border: 1px solid black;
        border-collapse: collapse; }
    th, td { border: 1px solid black; }
    th { background-color: lightpink; color: black; }
    td { text-align: center; }
    tr:nth-child(even) { background-color: #f2f2f2; }
    tr:hover { background-color: darksalmon; }  
</style>
</head>
<body>
	<!-- 3. 화면출력 -->
	<h2>성적처리결과(05_resp.jsp)</h2>
	<table border>
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>국어</th>
			<td><%=kor %></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><%=kor %></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><%=kor %></td>
		</tr>
		<tr>
			<th>합계</th>
			<td><%=tot %></td>
		</tr>
		<tr>
			<th>평균</th>
			<td><%=avg %></td>
		</tr>
	</table>
</body>
</html>