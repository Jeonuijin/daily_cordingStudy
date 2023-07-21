package com.mystudy.list5_list_VO;

import java.util.ArrayList;

public class StudentListManagerMain {

	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO, StudentListManager - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 전체 데이터 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		5. 전체 데이터 화면 출력
		========================================== */
		StudentVO st = new StudentVO("홍길동", 100, 90, 81);
		StudentVO st1 = new StudentVO("이순신", 95, 88, 92);
		StudentVO st2 = new StudentVO("김유신", 90, 87, 77);
		
		ArrayList<StudentVO> ar = new ArrayList<StudentVO>();		
		ar.add(st);
		ar.add(st1);
		ar.add(st2);
		
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		
		//4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		
		ar.get(2).setKor(95);
		System.out.println(ar.get(2));
		
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getName() + "\t"+ ar.get(i).getKor()  + "\t"+ 
					ar.get(i).getEng() + "\t" + ar.get(i).getMath());
		}
		
		
		
	}

}
