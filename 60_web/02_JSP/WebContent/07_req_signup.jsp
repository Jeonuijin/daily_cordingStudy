<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	function send_go() {
		alert(">> send_go() 실행");
		//alert("-"+document.frm.username.value+"-");//document에있는 frm, frm에있는 username의 값찾기
		if (document.frm.username.value.trim() == "") {		//username값을 반드시 입력하게 하는 if문
			alert("이름을 입력하세요");
			document.frm.username.value = ""; //이름을 빈칸으로 입력했을때 빈문자열 지워주기
			document.frm.username.focus(); //함수호출, focus() : username칸으로 포커스(커서)가 가게 함
			return false; //함수실행종료(서버쪽 전송처리 안함)
		}
		let vForm = document.frm;  //반복되는 부분 변수처리
		console.log("vForm id : " + vForm.getAttribute("id")
				+ ", name : " + vForm.getAttribute("name")); //.getAttribute() : 속성값 불러오는 메소드
		
		if (vForm.userid.value.trim().length < 1) {	//userid가 최소 1글자 이상
			alert("아이디를 입력하세요");
			vForm.userid.value = "";
			vForm.userid.focus();
			return false;
		}
		if (vForm.pwd.value.trim().length < 1) {	//userid가 최소 1글자 이상
			alert("암호를 입력하세요");
			vForm.pwd.value = "";
			vForm.pwd.focus();
			return false;
		}	
		if (vForm.pwd2.value.trim().length < 1) {	//userid가 최소 1글자 이상
			alert("확인암호를 입력하세요");
			vForm.pwd2.value = "";
			vForm.pwd2.focus();
			return false;
		}
		
		if (vForm.pwd.value != vForm.pwd2.value) {
			alert("암호가 다릅니다. \n확인 후 다시 입력하세요.");	
			vForm.pwd.value = "";
			vForm.pwd2.value = "";
			vForm.pwd.focus();
			return false;
		}
		console.log(vForm.gender); //2개가 선택됨
		let genders = vForm.gender;
		let checked = false;  //checked를 false로 초기화, 체크를 안했다는 의미
		for (let gender of genders) {
			if (gender.checked) checked = true;
		}
		if (!checked) {
			alert("<성별> 확인이 안되었습니다.\n선택해주세요");
			return;	//함수실행 끝
		}
		alert("서버로 전송처리");
		
		// 07_resp.jsp 서버에 결과값 보내기
		vForm.action = "07_resp.jsp"; //form태그에 작성도 가능
		vForm.submit(); 
				
		
	}
</script>
</head>
<body>
	<h1>회원가입(07_req_signup.jsp)</h1>
	<form name="frm" id="signupForm">
		<fieldset>
		<legend>회원가입</legend>
		<p>이름 : <input type="text" name="username"></p>
		<p>아이디 : <input type="text" name="userid"></p>
		<p>암호 : <input type="password" name="pwd"></p>
		<p>암호확인 : <input type="password" name="pwd2"></p>
		<p>이메일 : <input type="email" name="email"></p>
		<p>성별 : 
			<input type="radio" name="gender" value="남" class="gender">남
			<input type="radio" name="gender" value="여" class="gender">여
		</p>
		<p>취미 :
			<input type="checkbox" name="hobby" value="운동">운동
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="영화">영화
			<input type="checkbox" name="hobby" value="독서">독서
		</p>
		
		<input type="button" value="회원가입" onclick="send_go()">
		<input type="reset" value="초기화">
		</fieldset>
	</form>	
</body>
</html>