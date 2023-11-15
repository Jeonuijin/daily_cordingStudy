<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>책 상세정보</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
input[readonly] {
	border: none; /* 테두리 제거 */
	outline: none; /* 포커스 표시 제거 */
	background-color: transparent; /* 배경 색상 투명으로 설정 */
}

/* 테두리를 표시한 일반 input 요소에 대한 스타일 */
input {
	border: 1px solid #ccc; /* 기본 테두리 스타일 지정 */
	padding: 5px; /* 내부 여백 설정 (선택 사항) */
}

textarea[readonly] {
	border: none; /* 테두리 제거 */
	outline: none; /* 포커스 표시 제거 */
	background-color: transparent; /* 배경 색상 투명으로 설정 */
}

textarea {
	border: 1px solid #ccc; /* 기본 테두리 스타일 지정 */
	padding: 5px; /* 내부 여백 설정 (선택 사항) */
}
</style>
<script>
var bookId = "" 
var memId = ""	
//리뷰 조회 ajax
function loadComments() {
	 bookId = "${list[0].bookId}";
	 //memId = "$("#memId").val()";
	 
    $.ajax("getBookReview",{
        type: "GET",
        data: { bookId: bookId },/* { memId: memId}, */
        dataType: "json",
        success: function(data) {
        	
			//alert("Ajax 처리 성공 - 응답받은 데이터 : " + data);
			let htmlTag = "";
			let alist = data.list; 
			$.each(alist, function(index, category){
				//console.log("this.name : " + this.name);
				//console.log("member.name : " + member.name);
				memId = this.memId;
				htmlTag += "<tr>";
				htmlTag += "<td><input type='text' class='memId' value='작성자 id : " + this.memId + "' readonly></td>";
				 htmlTag += "<td><input type='radio' class='Grade' name='grade' value='1' id='grade1' hidden>";
		            htmlTag += "<label for='grade1' hidden>1점</label>";
		            htmlTag += "<input type='radio' class='Grade' name='grade' value='2' id='grade2' hidden>";
		            htmlTag += "<label for='grade2'hidden>2점</label>";
		            htmlTag += "<input type='radio' class='Grade' name='grade' value='3' id='grade3' hidden>";
		            htmlTag += "<label for='grade3' hidden>3점</label>";
		            htmlTag += "<input type='radio' class='Grade' name='grade' value='4' id='grade4' hidden>";
		            htmlTag += "<label for='grade4' hidden>4점</label>";
		            htmlTag += "<input type='radio' class='Grade' name='grade' value='5' id='grade5' hidden>";
		            htmlTag += "<label for='grade5' hidden>5점</label>";
			//	htmlTag += "</tr>";
			//	htmlTag += "<tr>";
				htmlTag += "<td><input type='text' class='Grade2' value='평점 : " + this.Grade + "점' readonly></td>";
				htmlTag += "<td><input type='text' class='reviewId' value='" + this.reviewId +  "' hidden></td>";
			//	htmlTag += "</tr>";
				
				 
	      
	          //  htmlTag += "<tr>";
	          htmlTag += "<td><textarea class='reviewContent' readonly>" + this.reviewContent + "</textarea></td>";
				//htmlTag += "</tr>";
				//htmlTag += "<tr>";
				htmlTag += "<td><input type='text' class='RegDate' value='" + this.RegDate + "' readonly></td>";
			//	htmlTag += "</tr>";
				htmlTag += "<td><button onclick='deleteReview(" + this.reviewId + ")'>삭제</button></td>";
				// 수정 버튼 추가 및 클릭 시 리뷰 수정 폼 열기
				htmlTag += "<td><button class='editButton'>수정</button></td>";
				htmlTag += "</tr>";
			    if (index < alist.length - 1) {
			        htmlTag += "<tr><td colspan='8'><hr></td></tr>";
			    }
			
			});
			 $("#commentBody").html(htmlTag); // 댓글을 테이블에 추가
			 $(".editButton").click(function() {
					let $row = $(this).closest("tr");
					
					
					// 라디오 버튼 활성화 (수정 버튼을 눌렀을 때만 활성화)
				    $row.find("input[type='radio']").prop("hidden", false);
				    $row.find("label").prop("hidden", false);
				    // readonly 속성을 제거하여 편집 가능하게 함
				    $row.find(".reviewContent").prop("readonly", false);
				    $row.find(".Grade").prop("readonly", false);
				    //$row.find(".memId").prop("readonly", false);
				    $row.find(".RegDate").prop("readonly", false);
				    
				    // 날짜 부분 숨기기
				    $row.find(".RegDate").hide();
				    //평점부분 숨기기
				     $row.find(".Grade2").hide();
				    
				    // 버튼 텍스트를 "저장"으로 변경하고 이벤트 핸들러를 업데이트
				    $(this).text("저장").removeClass("editButton").addClass("saveButton").off("click");
				    
				    $(this).click(function() {
				         // 업데이트된 값을 가져옴
				         let reviewContent = $row.find(".reviewContent").val();
				         let grade = $row.find("input[name='grade']:checked").val();
				         let reviewId = $row.find(".reviewId").val();
				         
				         // AJAX를 사용하여 업데이트 작업			         
						 	  $.ajax({
								type: "GET",
								url: "ReviewUpdate",
								data: {
										reviewId: reviewId,
										grade: grade,
										reviewContent: reviewContent,
				  
										 },
				            dataType: "json",
				            success: function(respData) {
				                if (respData.result === "success") {
				                    alert("리뷰가 성공적으로 수정되었습니다.");
				                    document.getElementById("reviewForm").reset();
				                    loadComments();
				                } else {
				                    alert("리뷰 수정에 실패했습니다.");
				                    
				                }
				            },
				            error: function(jqXHR, textStatus, errorThrown) {
				                alert("실패!! 값을 입력하세요");
				                
				            }
				        });
				        return false; 
				         // 날짜 부분 다시 표시
						//$row.find(".RegDate").show();
				         
				     });
				});
			 
        },
        error:  function(jqXHR, textStatus, errorThrown){
			alert(">> Ajax 처리 실패 : \n"
					+ "jqXHR.readyState : " + jqXHR.readyState + "\n"
					+ "textStatus : " + textStatus + "\n"
					+ "errorThrown : " + errorThrown);
		}
    });
}



//입력시에 입력 안했을때 check
function validateForm() {
    var grade = document.getElementsByName("grade");
    var isChecked = false;

    for (var i = 0; i < grade.length; i++) {
        if (grade[i].checked) {
            isChecked = true;
            break;
        }
    }

    if (!isChecked) {
        alert("도서 평점을 선택해주세요.");
        return false; // 페이지 전환을 막음
    }

    var content = document.getElementsByName("content")[0].value;
    if (content.trim() === "") {
        alert("내용을 입력해주세요.");
        return false; // 페이지 전환을 막음
    }

    return true; // 선택된 평점이 있고 내용이 입력되면 페이지 전환을 허용
}


//리뷰등록 ajax
$(document).ready(function() {
    $("#submitReviewButton").click(function() {
        var memId = $("#memId").val();
        var grade = $("input[name='grade']:checked").val();
        var reviewContent = $("#reviewContent").val();
        var bookId = $("#bookId").val();

        $.ajax({
            type: "GET",
            url: "bookReview",
            data: {
                memId: memId,
                grade: grade,
                reviewContent: reviewContent,
                bookId: bookId
            },
            dataType: "json",
            success: function(respData) {
                if (respData.result === "success") {
                    alert("리뷰가 성공적으로 저장되었습니다.");
                    document.getElementById("reviewForm").reset();
                    loadComments();
                } else {
                    alert("리뷰 저장에 실패했습니다.");
                    
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert("로그인 후 이용해주세요");
            }
        });
        return false; 
    });
});

loadComments(); //페이지 로딩 시 댓글을 불러오는 함수호출

//리뷰수정
function openUpdateReviewForm(memId, reviewId, reviewContent) {
	alert("댓글수정시작");
    var reviewDiv = $("#review-" + reviewId);
    reviewDiv.empty(); // 댓글 내용을 비웁니다.

    var updateForm = $("<form>");
    updateForm.attr("id", "updateForm-" + reviewId);

    var inputField = $("<input>");
    inputField.attr("type", "text");
    inputField.attr("value", reviewContent);
    inputField.attr("id", "updateReviewContent-" + reviewId);
    inputField.attr("name", "updateReviewContent");
    inputField.attr("required", "required");

    var saveButton = $("<button>");
    saveButton.attr("type", "button");
    saveButton.text("저장");
    saveButton.click(function() {
        var updatedReviewContent = $("#updateReviewContent-" + reviewId).val();
        // 여기에 수정된 내용을 서버로 보내는 AJAX 요청을 추가할 수 있습니다.

        // 수정 내용을 저장한 후, 수정 폼을 닫고 댓글을 업데이트합니다.
        closeUpdateReviewForm(memId, reviewId, updatedReviewContent);
    });

    var cancelButton = $("<button>");
    cancelButton.attr("type", "button");
    cancelButton.text("취소");
    cancelButton.click(function() {
        closeUpdateReviewForm(memId, reviewId, reviewContent);
    });

    updateForm.append(inputField);
    updateForm.append(saveButton);
    updateForm.append(cancelButton);

    reviewDiv.append(updateForm);
}
function closeUpdateReviewForm(memId, reviewId, updatedReviewContent) {
    var reviewDiv = $("#review-" + reviewId);
    reviewDiv.empty(); // 댓글 내용을 비웁니다.

    // 수정된 내용으로 댓글을 업데이트합니다.
    reviewDiv.append(updatedReviewContent);

    // 여기에 수정 내용을 서버로 보내는 AJAX 요청을 추가할 수 있습니다.
}
//아이디값 받아서 리뷰삭제 ajax
function deleteReview(reviewId) {

    // 삭제 버튼을 클릭할 때 호출될 함수
    $.ajax({
        type: "GET",
        url: "deleteReview",
        data: {
            memId: memId, // memId를 Ajax 요청 데이터에 추가
            reviewId: reviewId
        },
        dataType: "json",
        success: function(respData) {
            if (respData.result === "success") {
                alert("리뷰가 성공적으로 삭제되었습니다.");
                loadComments(); // 댓글을 다시 로드하여 최신 상태 유지
            } else {
                alert("리뷰 삭제에 실패했습니다.");
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert("Ajax 처리 실패: " + textStatus + ", " + errorThrown);
        }
    });
}
</script>
</head>
<body>

	<h2>책 상세정보</h2>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.category}</td>
			<td>${vo.bookName}</td>
			<td>${vo.price}</td>
			<td>${vo.publisher}</td>
			<td>${vo.author}</td>
			<td>${vo.details}</td>
			<td>${vo.bookId}</td>
			<td><img src="<c:url value='/upload/${vo.bookImage}' />"
				alt="Image"></td>
		</tr>
	</c:forEach>
	<hr>
	<h3>-- 리뷰 --</h3>
	
	<form id="reviewForm" action="bookReview" method="get"
		onsubmit="return validateForm();">
		<p>
			작성자 아이디: <input type="text" id="memId" name="memId">
		</p>

		<p>
			도서 평점: <input type="radio" name="grade" value="1" id="grade1"><label
				for="grade1">1점</label> <input type="radio" name="grade" value="2"
				id="grade2"><label for="grade2">2점</label> <input
				type="radio" name="grade" value="3" id="grade3"><labelfor "grade3">3점</label>
        <input type="radio" name="grade" value="4" id="grade4"><label for="grade4">4점</label>
        <input type="radio" name="grade" value="5" id="grade5"><label for="grade5">5점</label>
    </p>
		<input type="hidden" id="bookId" name="bookId"
			value="${list[0].bookId}"> <input type="hidden"
			name="bookImage" value="${list[0].bookImage}">
		<p>
			내용:
			<textarea id="reviewContent" name="reviewContent" rows="4" cols="55"></textarea>
		</p>
		<input type="submit" id="submitReviewButton" value="댓글저장">

	</form>
	<table id="commentTable">
		<thead>
			<tr>
				<th>작성자 아이디</th>
				<th>도서 평점</th>
				<th>리뷰 내용</th>
			</tr>
		</thead>
		<tbody id="commentBody">
			<!-- 댓글이 여기에 동적으로 추가될 것입니다 -->
		</tbody>
		
	</table>
	<hr>
</body>
</html>