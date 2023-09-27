<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청</title>
</head>
<body>
	<h1>요청(10_req.jsp - 응답 forward)</h1>
	<form>
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="text" name="pwd"><br>
		
		<input type="button" value="포워딩(forward)" onclick="send_forward(this.form)">	<!-- form객체 전달 -->		
	</form>
	
<script>
	function send_forward(frm) {
		//alert("send_forward(frm) 실행 frm : " + frm);
		frm.action = "10_resp_forward.jsp";	//form객체를 전달받아 action(서버요청)을 연결하는 방법
		frm.submit();
	}
</script>
</body>
</html>