package com.mystudy.list5_list_VO;

import java.util.List;
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
		
		List<StudentVO> ar = new ArrayList<StudentVO>();		
		ar.add(st);
		ar.add(st1);
		ar.add(st2);
		
		System.out.println(">>>3. list에 있는 전체 데이터 화면출력");
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		System.out.println();
		
		//4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		System.out.println(">>>4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력");
		for(int i = 0; i < ar.size();i++) {
			if("김유신".equals(ar.get(i).getName())) {
				ar.get(i).setKor(95);
				System.out.println("김유신 데이터만 출력 : " + ar.get(i));
			}
		}
		
//		int i = 0;
//		while (i < ar.size()) {
//			if("김유신".equals(ar.get(i).getName())) {	
//			ar.get(i).setKor(200);
//			System.out.println(ar.get(i));
//			}
//			i++;
//		}	
		
		for (StudentVO student : ar) {
			if ("김유신".equals(student.getName())) {
				student.setKor(95);
				student.computeTotAvg();
				break;
			}
		}
		
		//전체데이터 화면출력
		
		
		
		st.computeTotAvg();
		st1.computeTotAvg();
		st2.computeTotAvg();
		
		System.out.println();
		System.out.println(">>> 데이터 변경 후 전체출력");
		
		printData(ar);
		
		for (int idx = 0; idx < ar.size(); idx++) {
			StudentVO vo = ar.get(idx);  // ar.get(idx)를 반복할것이기 때문에 변수사용
			System.out.println(vo.getName() + "\t"+ 
					vo.getKor()  + "\t"+ 
					vo.getEng() + "\t" + 
					vo.getMath() + "\t"+
					vo.getTot() + "\t" + 
					vo.getAvg());
					
		}
	//메소드 만들어서 출력하기	
		for (StudentVO student : ar) {
			printData(student);
		}
		//object의 equals()는 동일 객체냐? 물어보는 것
		System.out.println("=============");
		//StudentVO equals() 구현 후 contains(), indexOf() 정상동작
		System.out.println("ar.contains(st) : " + ar.contains(st));
		System.out.println(ar.contains(st1));
		System.out.println(ar.indexOf(st));
		System.out.println("-----------------");
		StudentVO test = new StudentVO("김유신", 0 , 0, 0);
		System.out.println(ar.contains(test));
		System.out.println(ar.indexOf(test));
		
		System.out.println("김유신 국어점수 88점으로 수정");
		StudentVO kim = new StudentVO("김유신", 88, 0, 0);
		System.out.println(ar.contains(kim));
		System.out.println(ar.lastIndexOf(kim));
		System.out.println("----------------------");
		
		int idx = ar.indexOf(kim);
		StudentVO arKim = ar.get(idx);
		System.out.println(">>리스트의 원본데이터");
		printData(arKim);
		
		System.out.println(">>국어 점수 수정처리---");
		arKim.setKor(kim.getKor());
		arKim.computeTotAvg();
		System.out.println();
		
		System.out.println(">>리스트 수정본");
		System.out.println(arKim);
	
	}
	
	static void printData(StudentVO vo) {
		System.out.println(vo.getName() + "\t"+ 
				vo.getKor()  + "\t"+ 
				vo.getEng() + "\t" + 
				vo.getMath() + "\t"+
				vo.getTot() + "\t" + 
				vo.getAvg());
		
	}

	static void printData(List<StudentVO> ar) {
		for (StudentVO student : ar) {
			printData(student);
		}
	}

	
}
