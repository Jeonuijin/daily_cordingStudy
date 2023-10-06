	function sel_all(frm) { //전체데이터 조회
		frm.action = "selectAll.jsp";
		frm.submit();
	}
	function sel_one(frm) { //아이디로 데이터 조회
		frm.action = "SelectOneID.jsp";
		frm.submit();
	}
	function add_go(frm) {
		alert("입력된 값으로 DB에 입력처리");
	}