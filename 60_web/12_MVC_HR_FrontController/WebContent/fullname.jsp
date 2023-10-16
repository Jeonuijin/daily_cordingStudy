<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름으로검색</title>
</head>
<body>
	<h1>이름으로검색 [ fullname.jsp ]</h1>
	<form action="controller" method="post"> <!-- get방식을 쓰면 type=deptList로 설정해둔 파라미터 값이 사라지고 name="deptno" 값만 파라미터로 남게 된다. 따라서 get, post방식을 모두 사용하기 위해서는 hidden처리 해서 따로 파라미터를 넘겨준다. -->
		성명 : <input type="text" name="name">
		<input type="submit" value="이름으로 검색">
		<input type="hidden" name="type" value="fullname">
	</form>
</body>
</html>



