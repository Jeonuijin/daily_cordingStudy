package com.mystudy.map2_exam_vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentMapManagerMain {

	public static void main(String[] args) {
		/* (실습) Map<K, V> 데이터 다루기
		 사용클래스명 : StudentVO, StudentSetManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   ---------------------
		2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		3. map에 있는 데이터를 사용해서 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. "김유신" 국어 점수를 95 점으로 수정
		5. 수정된 "김유신" 데이터만 출력 확인
		6. 전체 데이터 화면 출력
		======================================== */
		String s = "학생번호 : 성명\t국어\t영어\t수학\t총점\t평균";
		String s1 = "-----------------------------------------------------";
		
//		1. StudentVO 클래스를 사용해서
//		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		StudentVO vo = new StudentVO("1","홍길동", 100, 90, 81);
		StudentVO vo1 = new StudentVO("2","이순신", 95, 88, 92);
		StudentVO vo2 = new StudentVO("3","김유신", 90, 87, 77);
		
		HashMap<String, StudentVO> map = new HashMap<String, StudentVO>();
		
//		2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		map.put(vo.getNumber(), vo);
		map.put(vo1.getNumber(), vo1);
		map.put(vo2.getNumber(), vo2);
		
		vo.num();
		vo1.num();
		vo2.num();
		
//		3. map에 있는 데이터를 사용해서 화면출력
		Collection<StudentVO> values = map.values();
		
		for (StudentVO stu : values) {
			System.out.println(stu.toString());
		}
		System.out.println("====================================");
		
		System.out.println(">>map에 있는 데이터를 사용해서 화면출력");
		System.out.println(s);
		System.out.println(s1);
		Set<String> keySet = map.keySet();
		for (String a : keySet) {
			System.out.println(map.get(a));
		}
		System.out.println();
		
////	4. "김유신" 국어 점수를 95 점으로 수정
//		5. 수정된 "김유신" 데이터만 출력 확인
		System.out.println(">>김유신 국어 점수를 95 점으로 수정");
		System.out.println(s);
		System.out.println(s1);
		
		
		for (String a : keySet) {
			StudentVO student = map.get(a); // map.get(a).~ 의 반복되는 부분을 StudentVO타입의 변수에 저장해 사용
			if ("김유신".equals(student.getName())) {
				student.setKor(95);
				System.out.println(student);
			}
			
		}
		System.out.println();
		
//		6. 전체 데이터 화면 출력
		System.out.println(">>전체 데이터 화면 출력");
		System.out.println(s);
		System.out.println(s1);
		for (String a : keySet) {
			System.out.println(map.get(a));
		}


	}
	
	
}
