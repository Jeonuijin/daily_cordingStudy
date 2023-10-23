<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세정보</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

function loadComments() {
	 var bookId = "${list[0].bookId}";
    $.ajax("getBookReview",{
        type: "GET",
        data: { bookId: bookId },
        dataType: "json",
        success: function(data) {
        	
			alert("Ajax 처리 성공 - 응답받은 데이터 : " + data);
			let htmlTag = "";
			let alist = data.list; 
			$.each(alist, function(index, category){
				//console.log("this.name : " + this.name);
				//console.log("member.name : " + member.name);
				htmlTag += "<tr>";
				htmlTag += "<td>" + this.reviewContent + "</td>";
				htmlTag += "<td>" + this.Grade + "</td>";
				htmlTag += "<td>" + this.memId + "</td>";
				htmlTag += "<td>" + this.RegDate + "</td>";
				htmlTag += "</tr>";
			    if (index < alist.length - 1) {
			        htmlTag += "<tr><td colspan='4'><hr></td></tr>";
			    }
			
			});
			 $("#commentBody").html(htmlTag); // 댓글을 테이블에 추가
        },
        error:  function(jqXHR, textStatus, errorThrown){
			alert(">> Ajax 처리 실패 : \n"
					+ "jqXHR.readyState : " + jqXHR.readyState + "\n"
					+ "textStatus : " + textStatus + "\n"
					+ "errorThrown : " + errorThrown);
		}
    });
}

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
                alert("Ajax 처리 실패: " + textStatus + ", " + errorThrown);
            }
        });
        return false; 
    });
});

loadComments(); //페이지 로딩 시 댓글을 불러오는 함수호출

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
        <td><img src="<c:url value='/upload/${vo.bookImage}' />" alt="Image"></td>
    </tr>
</c:forEach>
<hr>
<h3>-- 리뷰 --</h3>

<form id="reviewForm" action="bookReview" method="get" onsubmit="return validateForm();">
    <p>작성자 아이디: <input type="text" id="memId" name="memId"></p>

    <p>도서 평점: 
        <input type="radio" name="grade" value="1" id="grade1"><label for="grade1">1점</label>
        <input type="radio" name="grade" value="2" id="grade2"><label for="grade2">2점</label>
        <input type="radio" name="grade" value="3" id="grade3"><label for "grade3">3점</label>
        <input type="radio" name="grade" value="4" id="grade4"><label for="grade4">4점</label>
        <input type="radio" name="grade" value="5" id="grade5"><label for="grade5">5점</label>
    </p>
    <input type="hidden" id="bookId" name="bookId" value="${list[0].bookId}">
    <input type="hidden" name="bookImage" value="${list[0].bookImage}">
    <p>내용: <textarea id="reviewContent" name="reviewContent" rows="4" cols="55"></textarea></p>
    <input type="submit" id="submitReviewButton" value="댓글저장">
    
</form>
<table id="commentTable">
    <thead>
        <tr>
            <th>리뷰 내용</th>
            <th>도서 평점</th>
            <th>작성자 아이디</th>
        </tr>
    </thead>
    <tbody id="commentBody">
        <!-- 댓글이 여기에 동적으로 추가될 것입니다 -->
    </tbody>
</table>
<hr>
</body>
</html>