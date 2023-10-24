<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../CSS/main.css">

	<div class="common_lnb">
				<ul>
					<li><a href="javascript:myinfoheader();" class="on">마이페이지</a></li>
					
					<li><a href="https://ypbooks.co.kr/login.yp">로그인</a></li>
					<li><a href="https://ypbooks.co.kr/member.yp">회원인증/가입</a></li>
					
					<li><a href="/cart.yp">장바구니</a></li>
					<li><a href="javascript:fLoginCheck02();">주문/배송조회</a></li>
					<li><a href="/customer_center.yp">고객센터</a></li>
				</ul>
			</div>
<div id="commonHd">
	<div class="common_header">
		<!-- <div class="header_bgimg_wrap" style="position: absolute; margin: 0 auto; left: calc(50% - 724px); bottom: 0px; height: 219px;">
	        <img src="https://img.ypbooks.co.kr/ypbooks/images/common/header_bgimg.gif" alt="" class="header_bgimg" style="width:1480px; height:219px;">
	    </div> -->
		<div class="area">
			<!-- lnb -->
			<div class="common_lnb">
				<ul>
					<li><a href="javascript:myinfoheader();" class="on">마이페이지</a></li>
					
					<li><a href="https://ypbooks.co.kr/login.yp">로그인</a></li>
					<li><a href="https://ypbooks.co.kr/member.yp">회원인증/가입</a></li>
					
					<li><a href="/cart.yp">장바구니</a></li>
					<li><a href="javascript:fLoginCheck02();">주문/배송조회</a></li>
					<li><a href="/customer_center.yp">고객센터</a></li>
				</ul>
			</div>
			<!-- //lnb -->
			<!-- head -->
			<div class="common_head">
				<!-- logo -->
				<div class="logo_wp head_con">
					<a href="/kor_index.yp">
										
						<div style="position: relative;">
							<p><img alt="" src="https://img.ypbooks.co.kr/ypbooks/images/common/yp_logo.png"></p>												
						</div>
					</a>
				</div>
				<!-- //logo -->
				<!-- search -->
				<div id="search" class="head_con">
					<div class="cl_wp">
						<a href="javascript:void(0);" class="ts_btn" id="searchA">통합검색</a>
						<ul class="cl_ul" id="searchListB" style="display: none;">
							<li><a href="javascript:void(0);">통합검색</a></li>
							<li><a href="javascript:void(0);">국내도서</a></li>
							<li><a href="javascript:void(0);">외국도서</a></li>
							<li><a href="javascript:void(0);">리뷰</a></li>
							<hr>
							<li><a href="javascript:void(0);" class="re-search-btn01 re-search-btn1" onclick="document.querySelector('.modal_box_wrap').style.display='block'">상세검색</a></li>
						</ul>
					</div>
					
			<!--[if gte ie 9]>
				  $('html').click(function(e){
					  if($(e.target).parents('.modal_box').length < 1){
						  $(".modal_box_wrap").stop().hide();	  
					  }
				  }); 
			<![endif]-->
			
			<script>
			var t = document.querySelector('body');
			var mb_w = document.querySelector('.modal_box_wrap');
			if(t.addEventListener){
			    t.addEventListener('click', function(e){
			    	e.target === mb_w ? mb_w.style.display = "none" : false;
			    }); 
			} else if(t.attachEvent){
			    t.attachEvent('onclick', function(e){
			    	e.target === mb_w ? mb_w.style.display = "none" : false;
			    })
			}
			
			</script>
					
					<span class="tq_wp">
						<input name="t_query" type="text" id="t_query" value="" size="35" maxlength="100" autocomplete="off" onkeypress="javascript:e13('t');clearSort();enterSubmit(event.keyCode, 't');">
					</span> 
					<div class="btn_wp">
						<a href="javascript:void(0);" id="set_removetext" class="erase" onclick="inputReset()" style="display:none;">X</a>
						<a href="javascript:void(0);" id="set_sugicn" class="cm_dw" style="display: block;"><img src="https://img.ypbooks.co.kr/ypbooks/images/common/btnSearchBarDown.gif" id="sugicn" alt="검색창 아래 화살표"></a>
						<a href="javascript:void(0);" id="set_sugicnUP" class="cm_dw" style="display:none;"><img src="https://img.ypbooks.co.kr/ypbooks/images/btnSearchBarUp.gif" id="sugicnUP" alt="검색창 위 화살표"></a>
						<a href="javascript:void(0);" onclick="searchSubmit('t');" class="cm_sr"><img src="https://img.ypbooks.co.kr/ypbooks/images/common/top_search.gif" alt="검색 아이콘"></a>
					</div>
					<div id="SchSug">
						<iframe id="hFrame" name="hFrame" src="/ypbooks/search/Main/ark/ark_iframe.html" scrolling="no" frameborder="0" style="display: none;"></iframe>
					</div>
				</div>
			    
				<script>
					function inputReset(){
						var inputval = document.getElementById("t_query");
						inputval.value = null;
					}
				</script>
  
				<!-- //search -->

		<!-- 상단 탑배너 -->
		
		<div class="small_bn head_con">
			<div class="slide_area">
				<div class="sb_wp">
					<ol class="slide">
					
						<li class="bn_con"><a href="/book.yp?bookcd=101260129"><img src="https://img.ypbooks.co.kr/upload/banner/top_small_185.png" alt="광고배너"></a></li>
					
						<li class="bn_con"><a href="/book.yp?bookcd=101255415"><img src="https://img.ypbooks.co.kr/upload/banner/top_small_186.png" alt="광고배너"></a></li>
					
						<li class="bn_con"><a href="/book.yp?bookcd=101259483"><img src="https://img.ypbooks.co.kr/upload/banner/top_small_187.png" alt="광고배너"></a></li>
					
						<li class="bn_con on"><a href="/book.yp?bookcd=101259343"><img src="https://img.ypbooks.co.kr/upload/banner/top_small_188.png" alt="광고배너"></a></li>
					
					</ol>
				</div>
				<div class="small_info">
					<span class="sb_count">
						<span class="sb_now">4</span>/<span class="sb_total">4</span>
					</span>
					<span class="btn_wp bw0">
						<a href="javascript:void(0);" class="bn_prev"><img src="https://img.ypbooks.co.kr/ypbooks/images/common/top_prev.png" alt="이전버튼"></a>
						<a href="javascript:void(0);" class="bn_next"><img src="https://img.ypbooks.co.kr/ypbooks/images/common/top_next.png" alt="다음버튼"></a>
					</span>
				</div>
			</div>
		</div>
		

				<!-- //상단 탑배너 -->
				</div>
			</div>
			<!-- //head -->
			<!-- //menu -->
			
			<div class="gnb_wp">
				<div class="area">
					<ul class="common_gnb common_gnb01">
						<li><a href="/book_arrange.yp?targetpage=book_week_best&amp;pagetype=5&amp;depth=1">베스트도서</a></li>
						<li><a href="/book_arrange.yp?targetpage=book_topic_new&amp;pagetype=4&amp;depth=2">신간도서</a></li>
						<li><a href="/search_field.yp?category_type=1&amp;depth=4">국내도서</a></li>
						<li><a href="/eng_index.yp?depth=5&amp;pageIdx=eng&amp;c1=50">외국도서</a></li>
						<li><a href="/event_list.yp?depth=9">이벤트</a></li>
						<li><a href="https://ypbooks.co.kr/event_view.yp?HTMLPage=https://pub.ypbooks.co.kr/ypbooks/event/maintema/mainthema.jsp?evt_no=1035">기획/테마</a></li>
					</ul>
					<ul class="common_gnb common_gnb02">
						<li><a href="/culture_event.yp?depth=7">문화행사</a></li>
						<li><a href="/ypbooks/event/maintema/gifticon.jsp">기프티콘</a></li>
						<li><a href="https://ypbooks.co.kr/event_view.yp?HTMLPage=https://pub.ypbooks.co.kr/ypbooks/event/maintema/mainthema.jsp?evt_no=1031">회원혜택</a></li>
						<li><a href="/ypbooks_mobile/event/event_daily_login.jsp">출석체크</a></li>
					</ul>
				</div>
			<!-- //menu -->
			</div>
	</div>
</div>	

<html>
<head> 
<meta charset="UTF-8">
<title>카테고리 별 검색</title>
</head>
<body>
	<h1>카테고리별 도서 검색</h1>

	<!-- 베스트 도서 버튼 -->
	<form action="bestListCategory.jsp" method="get">
		<input type="hidden" name="category" value="best">
		<button type="submit">베스트 도서</button>
	</form>

	<!-- 신간 도서 버튼 -->
	<form action="newtListCategory.jsp" method="get">
		<input type="hidden" name="category" value="new">
		<button type="submit">신간 도서</button>
	</form>
</body>
</html>