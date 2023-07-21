package com.mystudy.list4_list_exam;

import java.util.ArrayList;

public class ArrayList_String_Exam {

	public static void main(String[] args) {
		/* List 중 ArrayList<String> 사용 실습
		   문자열 : "홍길동","이순신","이순신","을지문덕"
		 1. ArrayList 타입 names 변수를 선언하고 데이터 입력
		 2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		 	출력 예) 홍길동,이순신,이순신,을지문덕
		 3. List에 있는 데이터의 첫 글자만 출력
		 	출력 예) 홍,이,이,을
		 4. 이름이 을지문덕 찾아서 "인덱스번호:이름" 형태로 출력
		 	예) 3.을지문덕
		 5. 이름이 "이순신" 데이터 모두 삭제
		 */
		
		// 1. ArrayList 타입 names 변수를 선언하고 데이터 입력
		System.out.println("[문제1]");
		ArrayList<String> names = new ArrayList<>();	
		names.add("홍길동");
		names.add("이순신");
		names.add("이순신");
		names.add("을지문덕");
		
		// 2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		System.out.println("[문제2]");
		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i));
			if (i < names.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
//		// 3. List에 있는 데이터의 첫 글자만 출력
		System.out.println("[문제3]");
		System.out.println("=== StringBuilder를 이용하기 ===");
		StringBuilder st = new StringBuilder("홍길동,이순신,이순신,을지문덕");
		System.out.println(st);
		
		String[] st2 = st.toString().split(",");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.print(st2[i].charAt(0));
			if (i < names.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		boolean isFirst = true;
		for (String name : names) {
			if (isFirst) {
			System.out.print(name.charAt(0));
			isFirst = false;
			}else {
				System.out.print(", " + name.charAt(0));
			}
		}
		System.out.println();
		
//		for (int i = 0; i < names.size(); i++) {
//			System.out.print(names.get(i).charAt(0));
//			if (i < names.size()-1) {
//				System.out.print(", ");
//			}
//		}
		// 4. 이름이 을지문덕 찾아서 "인덱스번호:이름" 형태로 출력
		System.out.println("[문제4]");
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("을지문덕")) {
				System.out.println(i + " : " + names.get(i));
			}
		}
		//5. 이름이 "이순신" 데이터 모두 삭제
		System.out.println("[문제5]");
		int idx = names.size() -1 ;
		
		for (int i = idx; i >= 0; i--) {
			if (names.get(i).equals("이순신")) {
				names.remove(i);
			}
		}
		System.out.println(names);	
		
//		while (names.remove("홍길동")) {
//		}
//		System.out.println(names);
//		
		
	}

}
