package com.mystudy.set1_hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet_Exam {

	public static void main(String[] args) {
		// HashSet : Set 인터페이스 구현한 구현체(클래스)
		// 중복데이터 없음(동일데이터는 1개만 저장), 순서가 없다
		//-----------------------
		//Set에서 동일데이터 여부확인 hashCode(). equals() 값 확인
		//1. 해시코드 값 확인 : hashCode()
		//2. equals() 메소드 결과값이 모두 일치하면 동일데이터 처리
		
		HashSet<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("김유신");
		set.add("홍길동");
		set.add(new String("홍길동"));
		
		System.out.println("set : " + set);
		System.out.println("set.size() : " + set.size());
		System.out.println("\"홍길동\".hashCode() : " + "홍길동".hashCode());
		System.out.println("new String(\"홍길동\").hashCode() : " + new String("홍길동").hashCode());

		System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));
		System.out.println("set.contains(\"을지문덕\") : " + set.contains("을지문덕"));
	
		set.add("을지문덕");
		set.add("홍경래");
		
		System.out.println("set : " + set);
		
		System.out.println("--- Set 전체 데이터 조회 ---");
		for (String names : set) {
			System.out.println(names);
		}
		
		
		System.out.println("--- Set 전체 데이터 조회(Iterater 사용)---");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String name = ite.next();
			System.out.println(name);			
			//System.out.println(ite.next()); //개수가 줄어든다.
			//System.out.println(ite.next());
			
		}
		
		System.out.println("=== 김유신 ---> 강감찬 ===");
		// 수정(변경) : 김유신 ---> 강감찬
		// 일단 김유신이 있는지 확인하고 있으면 변경하고, 없으면 진행하지 마세요
		// 김유신 삭제 and 강감찬 입력
		// 강감찬 입력 and 김유신 삭제
		//------------
		System.out.println("수정 전 : " + set);
		
		if (set.contains("김유신")) {
			System.out.println(">> 데이터 있습니다");
			set.remove("김유신");
			set.add("강감찬");
		} else {
			System.out.println(">> 데이터 없음 : 작업처리 안함");
		}
		
		//있는지 확인하고 있으면 수정작업, 없으면 작업중단
		if (set.remove("홍길동2")) {
			System.out.println(":: 삭제 처리됨");
		}else {
			System.out.println(":: 없어서 삭제 못함");
		}
		
		System.out.println("수정후 : " + set);
		System.out.println("---- 전체데이터 화면 출력 ---");
		for (String names : set) {
			System.out.println(names);
		}
		
	}

}






