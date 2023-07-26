package com.mystudy.set2_exam_vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class StudentSetManagerMain {

	public static void main(String[] args) {
		/* (실습) Set 중 HashSet 또는 TreeSet 사용
		 사용클래스명 : StudentVO, StudentSetManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   ---------------------
		2. Set 타입의 변수(set)에 저장하고
		3. set에 있는 데이터를 사용해서 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. "김유신" 국어 점수를 95 점으로 수정
		5. 수정된 "김유신" 데이터만 출력 확인
		6. 전체 데이터 화면 출력
		======================================== */
		//주석처리되어있는 문제풀이는 ArrayList를 사용함
		
		//1. StudentVO 클래스를 사용해서
		   //3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		StudentVO vo = new StudentVO("홍길동", 100, 90, 81);
		StudentVO vo1 = new StudentVO("이순신", 95, 88, 92);
		StudentVO vo2 = new StudentVO("김유신", 90, 87, 77);
		
		//2. Set 타입의 변수(set)에 저장하고
		HashSet<StudentVO> set = new HashSet<StudentVO>();
		set.add(vo);
		set.add(vo1);
		set.add(vo2);
		
		vo.num();
		vo1.num();
		vo2.num();
		
		//set에 있는 데이터를 사용해서 화면출력
		System.out.println(">> set에 있는 데이터를 사용해서 화면출력");
		
		System.out.println("=== 개선된for문 사용 ===");
		for (StudentVO st : set) {
			System.out.println(st.toString()); //st.getName(), st.getKor()...을 VO에 메소드로 저장해 불러옴
		}
		System.out.println();
	
		
		System.out.println("===Iterator 사용 ===");
		Iterator<StudentVO> ite = set.iterator();
		while (ite.hasNext()) {
			//StudentVO stu = ite.next();
			//System.out.println(stu);
			
			System.out.println(ite.next());			
			//System.out.println(ite.next()); //개수가 줄어든다.
			//System.out.println(ite.next());
			//println이 Object 타입의 toString 을 불러오는 기능을 한다.
			
		}
		System.out.println();
//		ArrayList<StudentVO> ar = new ArrayList<>(set);
//		for (int i = 0; i < ar.size(); i++) {
//			StudentVO st = ar.get(i);
//			System.out.println(st.getName() + "\t" +
//							st.getKor() + "\t" 
//							+ st.getEng() + "\t" 
//							+ st.getMath()+ "\t"
//							+ st.getTot() + "\t"
//							+ st.getAvg());
//		}
		
		// 4. "김유신" 국어 점수를 95 점으로 수정
		// 5. 수정된 "김유신" 데이터만 출력 확인
		System.out.println(">>김유신 국어점수 수정 후 출력");
		for (StudentVO st : set) {
			if (st.getName().equals("김유신")) {
				st.setKor(95);
				System.out.println(st.toString());
			}
		}
		System.out.println();
		
		
//		System.out.println(">> 김유신 국어점수 수정 후 출력");
//		for (int i = 0; i < ar.size(); i++) {
//			StudentVO st = ar.get(i);
//			if (ar.get(i).getName().equals("김유신")) {
//				ar.get(i).setKor(95);
//				System.out.println(st.getName() + "\t" +
//						st.getKor() + "\t" 
//						+ st.getEng() + "\t" 
//						+ st.getMath()+ "\t"
//						+ st.getTot() + "\t"
//						+ st.getAvg());
//			}
//		}
		
//		//6. 전체 데이터 화면 출력
		System.out.println(">>전체 데이터 화면 출력");
		for (StudentVO st : set) {
			System.out.println(st.toString());
		}
		
//		System.out.println(">> 전체 데이터 화면 출력");
//		for (int i = 0; i < ar.size(); i++) {
//			StudentVO st = ar.get(i);
//			System.out.println(st.getName() + "\t" +
//							st.getKor() + "\t" 
//							+ st.getEng() + "\t" 
//							+ st.getMath()+ "\t"
//							+ st.getTot() + "\t"
//							+ st.getAvg());
//		}
		
		
		
		
		
		
		
		
	}

}
