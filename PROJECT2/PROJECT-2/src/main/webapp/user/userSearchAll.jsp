<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합검색</title>
<style>
.search {
	position: relative;
	width: 300px;
}

input {
	width: 100%;
	border: 1px solid #bbb;
	border-radius: 8px;
	padding: 10px 12px;
	font-size: 14px;
}

img {
	position: absolute;
	width: 17px;
	top: 10px;
	right: 12px;
	margin: 0;
	cursor: pointer; /* 커서 모양을 포인터로 변경하여 클릭 가능한 요소임을 표시 */
}
</style>
</head>
<body>
	<form action="searchAll" method="get">
		<div class="search">
			<input type="text" name="search" placeholder="통합검색">
			<div class="search-icon" onclick="submitForm()">
				<img
					src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
			</div>
		</div>
	</form>

	<script>
    function submitForm() {
        document.forms[0].submit(); // 폼 제출
    }
</script>
</body>
</html>