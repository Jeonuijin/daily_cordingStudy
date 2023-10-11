<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 VO 데이터를 화면에 표시하고 수정데이터 작성 --%>
<%
	//0. 전달받은 VO 데이터 확인(session에 저장된 데이터)
	System.out.println("update.jsp session guestbookVO : "
			+ session.getAttribute("guestbookVO"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록수정</title>
<link rel="stylesheet" type="text/css" href="../css/guestbook.css">
<script>
	function save_go(frm) {
		//alert("save_go(frm) 실행~~ frm : " + frm);
		//비밀번호 확인 후 일치하면 수정 요청 처리
		let pwd1 = frm.pwd.value; //지금 입력한 암호
		let pwd2 = "${guestbookVO.pwd}"; //DB에 저장된 암호(문자열 처리 안해주면 변수명으로 인식),저장된 암호는 소스코드에 표시됨(암호 노출)
		alert("pw1 : " + pwd1 + ", pw2 : " + pwd2);
		
		if (pwd1 !== pwd2) {
			alert("암호불일치. 암호를 확인하세요");
			frm.pwd.value = "";	//비밀번호 값 비우기(일치하지 않기 때문에)
			frm.pwd.focus();	//포커스 비밀번호창으로 가게설정
			return false;	//불일치하면 리턴, 일치하면 그대로 흘러내림
		}
		frm.action = "update_ok.jsp";
		frm.submit();
	}
</script>
</head>
<body>

<div id="container">
	<h2>방명록 : 수정화면</h2>
	<hr>
	<p><a href="list.jsp">[목록으로 이동]</a></p>
	
	<form action="update_ok.jsp" method="post">
	<table>
		<tbody>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${guestbookVO.name }"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${guestbookVO.subject }"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${guestbookVO.email }"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" rows="5" cols="60">${guestbookVO.content }</textarea>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="수 정" onclick="save_go(this.form)">
					<input type="reset" value="취 소">
					<input type="hidden" name="idx" value="${guestbookVO.idx }"> <!-- 파라미터 값으로 idx값을 넘겨줄때 브라우저 창에 보이지 않게 hidden을 사용한다. -->
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</div>

</body>
</html>