package com.mystudy.member.dao;

import java.util.List;

import com.mystudy.member.vo.MemberVO;
import com.mystudy.student.vo.StudentVO;

public class MemberDAO_Test {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		//Select
		List<MemberVO> list = dao.selectAll();
		
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
	//Insert
	MemberVO member = new MemberVO("hong2", "홍길동2", "1234", "010-0000-0000", "서울");
	int result = dao.insert(member);
	System.out.println("입력 결과 : " + result);
	System.out.println("전체 출력 : " + dao.selectAll());

}
}

