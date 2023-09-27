<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 주문한 내역에 따라서 계산하고 결과를 표시 --%>
<%
	//주문한 내역에 따라 계산하고 결과를 표시
	//1. 파라미터 값 추출(확인)
		int coffee = Integer.parseInt(request.getParameter("coffee"));
		int num = Integer.parseInt(request.getParameter("su"));
		int input = Integer.parseInt(request.getParameter("money"));
		int price = 0;
		String name = "";
		
		
	//2. 계산처리 : 구입금액, 잔액
		if (coffee == 1){
			price = 3000;
			name = "아메리카노";
		}else if (coffee == 2) {
			price = 3500;
			name = "카페모카";
		}else if (coffee == 3)	{
			price = 2500;
			name = "에스프레소";
		}else if (coffee == 4) {
			price = 4000;
			name = "카페라떼";
		}
	
	int totprice = price * num;
	int output = input - totprice;
	
	if (input < totprice) {
		System.out.println("입금액이 부족합니다.");
		response.sendRedirect("08_req_coffee.jsp");  //메뉴주문 페이지 재요청하기
		return;
	}
	//3. 결과표시
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문결과</title>
</head>
<body>
	<h2>주문 계산 결과(응답-08_resp.jsp)</h2>
	<ul>
		<li>커피종류 : <%=name %></li>
		<li>단가 : <%=price %></li>
		<li>수량 : <%=num %></li>
		<li>구입금액 : <%=totprice %> 원
		</li> -----------------------------
		<li>입금액 : <%=input %></li>
		<li>잔액 : <%=output %></li>
	</ul>
	<%--
	커피종류 : 아메리카노
	단가 : 4500원
	수량 : 3개
	구입금액 : 9000원 (단가 * 수량)
	-----------------------------
	입금액 : 10000원
	잔액 : 1000 (입금액 - 구입금액)
 --%>
</body>
</html>