<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
#book {
	margin-right: auto;
}

td {
	padding: 5px;
}
</style>
<script>
	$(document).ready(function(){
		$("#getDataBtn").on("click", ajaxGetSelectBestAll);
	});

	function ajaxGetSelectBestAll() {
		alert(">> ajaxGetSelectBestBook() 실행~~");
		
		$.ajax("getSelectBook?type=best", {
			type : "get",
			dataType : "json", //응답 받을 데이터 타입(형식)
			success : function(respData){
				alert(">> Ajax 처리 성공 - 응답받은 데이터 : " + respData);
				console.log(respData);
				console.log(respData.list);
				
				//전달받은 JSON 데이터 사용 tr 태그 만들고 화면출력
				let htmlTag = "";
				let alist = respData.list; //JSON 객체의 속성명 "list"의 값 추출
				$.each(alist, function(index, book){
					//console.log("this.name : " + this.name);
					//console.log("member.name : " + member.name);
					htmlTag += "<tr>";
					htmlTag += "<td>" + this.category + "</td>";
					htmlTag += "<td><a href='bookListOne?bookId=" + this.bookId + "'>" + this.bookName + "</td>";
					htmlTag += "<td>" + this.price + "</td>";
					htmlTag += "<td>" + this.publisher + "</td>";
					htmlTag += "<td>" + this.author + "</td>";
					htmlTag += "<td>" + this.details + "</td>";
					htmlTag += "<td>" + this.bookImage + "</td>";
					htmlTag += "</tr>";
				});
				$("#dispData").html(htmlTag);
			},
			error : function(jqXHR, textStatus, errorThrown){
				alert(">> Ajax 처리 실패 : \n"
						+ "jqXHR.readyState : " + jqXHR.readyState + "\n"
						+ "textStatus : " + textStatus + "\n"
						+ "errorThrown : " + errorThrown);
			}
		});
	}
	
	function ajaxGetSelectBestOne(category) {
		alert(">> getJsonMembersName 실행~~ 이름 : " + category);
		alert(">> encodeURIComponent(name) : " + encodeURIComponent(category));
		
		$.ajax("getSelectBestOne?type=best", {
			type : "get",
			data : "category=" + encodeURIComponent(category), //서버로 전달하는 데이터
			dataType : "json", //응답 받는 데이터 타입
			success : function(data) {
				
				alert("Ajax 처리 성공 - 응답받은 데이터 : " + data);
				let htmlTag = "";
				let alist = data.list; 
				$.each(alist, function(index, category){
					//console.log("this.name : " + this.name);
					//console.log("member.name : " + member.name);
					htmlTag += "<tr>";
					htmlTag += "<td>" + this.category + "</td>";
					htmlTag += "<td><a href='bookListOne?bookId=" + this.bookId + "'>" + this.bookName + "</a></td>";
					htmlTag += "<td>" + this.price + "</td>";
					htmlTag += "<td>" + this.publisher + "</td>";
					htmlTag += "<td>" + this.author + "</td>";
					htmlTag += "<td>" + this.details + "</td>";
					htmlTag += "<td><img src='" + this.bookImage + "' alt='Image'></td>";
					htmlTag += "</tr>";
				});
				$("#dispData").html(htmlTag);
			},
			error : function(jqXHR, textStatus, errorThrown){
				alert(">> Ajax 처리 실패 : \n"
						+ "jqXHR.readyState : " + jqXHR.readyState + "\n"
						+ "textStatus : " + textStatus + "\n"
						+ "errorThrown : " + errorThrown);
			}
		});
	}
</script>

<title>베스트 도서 카테고리</title>

</head>
<body>
	<h2>알라딩 베스트셀러입니다</h2>
	<table id="book">
		<tbody>
			<tr>
				<td><button id="getDataBtn">종합</button></td>
			</tr>
			<tr>
				<td><button onclick="ajaxGetSelectBestOne('인문과학')">인문과학</button></td>
			</tr>
			<tr>
				<td><button onclick="ajaxGetSelectBestOne('소설')">소설</button></td>
			</tr>
			<tr>
				<td><button onclick="ajaxGetSelectBestOne('어린이')">어린이</button></td>
			</tr>
			<tr>
				<td><button onclick="ajaxGetSelectBestOne('경제경영')">경제경영</button></td>
			</tr>
		</tbody>
	</table>
	<table border="1">
		<tr>
			<th>카테고리</th>
			<th>책이름</th>
			<th>가격</th>
			<th>출판사</th>
			<th>작가</th>
			<th>책설명</th>
			<th>책이미지</th>
		</tr>
		<tbody id="dispData"></tbody>
	</table>
</body>
</html>