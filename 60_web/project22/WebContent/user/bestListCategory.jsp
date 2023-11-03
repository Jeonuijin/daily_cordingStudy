<%@page import="com.project.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<%-- 현재 페이지에 표시할 데이터를 화면에 표시
	1. 페이징 처리를 위한 객체(Paging) 생성해서 필요한 데이터 참조
	2. 페이징 객채에 설정할 데이터 생성 저장
	3. (DB) 현제 페이지 표시할 게시글 데이터 조회
	4. 데이터 화면 표시(화면컨트롤 - 스타일 지정)
--%>


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
		ajaxGetSelectBestAll();
		$("#getDataBtn").on("click", ajaxGetSelectBestAll);
	});

	function ajaxGetSelectBestAll() {
		//alert(">> ajaxGetSelectBestBook() 실행~~");
		
		$.ajax("getSelectBook?type=best", {
			type : "get",
			data : "cPage=2",
			dataType : "json", //응답 받을 데이터 타입(형식)
			success : function(respData){
				//alert(">> Ajax 처리 성공 - 응답받은 데이터 : " + respData);
				console.log(respData);
				console.log(respData.list);
			//paging에대한 것도 가져오기, 카테고리에 대한 정보 보내기 (각각 카테고리이름이 다르기때문에)??????
				//전달받은 JSON 데이터 사용 tr 태그 만들고 화면출력
				let htmlTag = "";
				let alist = respData.list; //JSON 객체의 속성명 "list"의 값 추출
				$.each(alist, function(index, book){
					//console.log("this.name : " + this.name);
					//console.log("member.name : " + member.name);
					 // 이미지 크기 변경
                	let image = new Image();
               		 image.src = '../upload/' + this.bookImage;
               		 let maxWidth = 100; // 원하는 최대 너비
              		 let maxHeight = 100; // 원하는 최대 높이
					
              		 //if문 사용해서 이미지의 원래크기를 최대 너비, 높이에 맞추기
	                if (image.width > maxWidth) {
	                    image.height *= maxWidth / image.width;
	                    image.width = maxWidth;
	                }
	
	                if (image.height > maxHeight) {
	                    image.width *= maxHeight / image.height;
	                    image.height = maxHeight;
	                }
	                
	                let imageTag = "<img src='../upload/" + this.bookImage + "' alt='Image' width='" + image.width + "' height='" + image.height + "'>";
					htmlTag += "<tr>";
					htmlTag += "<td>" + imageTag + "</td>";
					htmlTag += "<td><a href='bookListOne?bookId=" + this.bookId + "'>" + this.bookName + "</td>";
					 htmlTag += "<td>" + this.price + " 원 <button type='button' id='inprice' class='btn btn-primary btn-block'>찜</button><button type='button' id='inprice' class='btn btn-secondary btn-block'>장바구니</button></td>";
					htmlTag += "<td>" + this.publisher + "</td>";
					htmlTag += "<td>" + this.author + "</td>";
					htmlTag += "<td>" + this.details + "</td>";
	                
					htmlTag += "</tr>";
				});
				$("#dispData").html(htmlTag);
<%-- 				<%
				//================================
				//현재 페이지 기준으로 DB데이터(게시글) 가져오기
				//시작번호(begin), 끝번호(end) 사용해서
				List<BbsVO> list = adminBookDAO.getPageList(p.getBegin(), p.getEnd());
				System.out.println(">> 현재 페이지 글목록(list) : " + list);
				
				//--------------------------
				//JSTL, EL 사용을 위해 scope에 데이터 등록(page 영역)
				pageContext.setAttribute("list", list);
				pageContext.setAttribute("pvo", p);
				
				//(개인적실습) 현재 페이지번호 사용 블록번호 구하고, 블록번호로 시작/끝 페이지 구하기
				System.out.println("p : " + p);	
			%> --%>
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
		//alert(">> getJsonMembersName 실행~~ 이름 : " + category);
		//alert(">> encodeURIComponent(name) : " + encodeURIComponent(category));
		
		$.ajax("getSelectBestOne?type=best", {
			type : "get",
			data : "category=" + encodeURIComponent(category), //서버로 전달하는 데이터
			dataType : "json", //응답 받는 데이터 타입
			success : function(data) {
				
				//alert("Ajax 처리 성공 - 응답받은 데이터 : " + data);
				let htmlTag = "";
				let alist = data.list; 
				$.each(alist, function(index, category){
					//console.log("this.name : " + this.name);
					//console.log("member.name : " + member.name);
					let image = new Image();
               		 image.src = '../upload/' + this.bookImage;
               		 let maxWidth = 100; // 원하는 최대 너비
              		 let maxHeight = 100; // 원하는 최대 높이
					
              		 //if문 사용해서 이미지의 원래크기를 최대 너비, 높이에 맞추기
	                if (image.width > maxWidth) {
	                    image.height *= maxWidth / image.width;
	                    image.width = maxWidth;
	                }
	
	                if (image.height > maxHeight) {
	                    image.width *= maxHeight / image.height;
	                    image.height = maxHeight;
	                }
	                
	                let imageTag = "<img src='../upload/" + this.bookImage + "' alt='Image' width='" + image.width + "' height='" + image.height + "'>";
					console.log(this.bookId);
					htmlTag += "<tr>";
					htmlTag += "<td>" + imageTag + "</td>";
					htmlTag += "<td><a href='bookListOne?bookId=" + this.bookId + "'>" + this.bookName + "</a></td>";
					 htmlTag += "<td>" + this.price + " 원 <button type='button' id='inprice' class='btn btn-primary btn-block'>찜</button><button type='button' id='inprice' class='btn btn-secondary btn-block'>장바구니</button></td>";
					htmlTag += "<td>" + this.publisher + "</td>";
					htmlTag += "<td>" + this.author + "</td>";
					htmlTag += "<td>" + this.details + "</td>";

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
<style>
	button:hover {
    background-color: #285a34;
    color: #eee;
	}
	table {
	text-align: center;

	}

	
</style>
<body>	
	
	<%@ include file="category.jsp" %>

	<div class="inner mt-5">	
	
		<div class="row">
			<div class="col-3">
				<ul class="nav nav-pills nav-fill flex-column" style="background-color: #f7f8f9;"  id="myTab" role="tablist">
					<li class="nav-item" role="presentation">
							<button class="nav-link active btn-lg btn-block" >베스트셀러</button>
					</li>
					<li class="nav-item" role="presentation">
							<button class="nav-link btn-lg btn-block" id="getDataBtn">종합</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link btn-lg btn-block" onclick="ajaxGetSelectBestOne('인문과학')">인문과학</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link btn-lg btn-block" onclick="ajaxGetSelectBestOne('소설')">소설</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link btn-lg btn-block" onclick="ajaxGetSelectBestOne('어린이')">어린이</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link btn-lg btn-block" onclick="ajaxGetSelectBestOne('경제경영')">경제경영</button>
					</li>
				</ul>
			</div>
			<table class="table table-hover col-9" border="1">
				<tr class="thead-light">
					<th>책이미지</th>
					<th>책이름</th>
					<th>가격</th>
					<th>출판사</th>
					<th>작가</th>
					<th>책설명</th>
					
				</tr>
				<tbody id="dispData"></tbody>
				
			</table>
		</div>
	</div>
	
	<style>
	.nav-pills .nav-link.active {background-color: #285a34; }
	.table td{vertical-align: middle; }
	#inprice { font-size: 12px;  padding: 5px 5px 5px 5px; margin-top: 10px; }
	
	</style>
</body>
</html>