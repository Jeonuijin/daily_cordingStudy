<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피주문</title>
<script>
	function function_go() {
		let vForm = document.frm;

		// 선택된 coffe의 value값 가져오기
		let selectedCoffee = "";
		let coffeeRadios = document.getElementsByName("coffee");
		for (let i = 0; i < coffeeRadios.length; i++) {
			if (coffeeRadios[i].checked) {
				selectedCoffee = coffeeRadios[i].value;
				break;
			}
		}
		// 선택된 커피 값을 alert로 표시
		//alert("선택된 커피: " + selectedCoffee);

		let price = 0;
		if (selectedCoffee == 1) {
			price = 3000;
		} else if (selectedCoffee == 2) {
			price = 3500;
		} else if (selectedCoffee == 3) {
			price = 2500;
		} else if (selectedCoffee == 4) {
			price = 4000;
		}
		let totprice = price * parseInt(vForm.su.value);
		let input = parseInt(vForm.money.value);

		if (vForm.money.value == "0" || vForm.money.value == "") {
			alert("입금액을 입력해주세요");
			vForm.money.focus();
			return false;
		} else if (input < totprice) {
			alert("입금액이 부족합니다.");
			vForm.money.focus();
			return false;
		}

		if (vForm.su.value == "0" || vForm.su.value == "") {
			alert("수량을 입력해주세요");
			vForm.su.focus();
			return false;
		}
		vForm.submit();
	}
</script>
</head>
<body>
	<h1>커피주문(요청-08_req_coffee.jsp)</h1>
	<form action="08_resp.jsp" name="frm">
		<input type="radio" name="coffee" value="1" checked>아메리카노(3000원)<br>
		<!-- checked : 디폴트로 체크할 값 -->
		<input type="radio" name="coffee" value="2">카페모카(3500원)<br>
		<input type="radio" name="coffee" value="3">에스프레소(2500원)<br>
		<input type="radio" name="coffee" value="4">카페라떼(4000원)<br>
		<hr>
		수량 : <input type="number" name="su" value="1"><br> 입금액 :
		<input type="number" name="money" value="0"><br> <input
			type="button" value="주문처리" onclick="function_go()">

	</form>


</body>
</html>