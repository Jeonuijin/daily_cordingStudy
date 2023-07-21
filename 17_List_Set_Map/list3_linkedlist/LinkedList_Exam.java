package com.mystudy.list3_linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_Exam {

	public static void main(String[] args) {
		// LinkedList : List 속성(List 인터페이스 구현체)
		LinkedList<String> list = new LinkedList<String>();
		//List<String> list = new LinkedList<String>();
		list.add("홍길동"); // 0번 인덱스
		list.add("홍길동"); // 1번 인덱스
		list.add("김유신");
		System.out.println("list : " + list);
		System.out.println("list.get(0) : " + list.get(0));

		list.remove("홍길동");
		System.out.println("list : " + list);
		
		String str = "홍길동,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동";
		String[] names = str.split(",");
		System.out.println("names : " + Arrays.toString(names));
		
		
		//배열에 있는 데이터를 리스트에 추가
		for(int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		System.out.println("list : " + list);
		
		//list : [홍길동, 김유신, 홍길동, 홍길동, 김유신, 강감찬, 을지문덕, 홍경래, 김유신, 홍길동]
		//--------------------------------------
		// (실습) 리스트에 있는 데이터 변경하기
		//1. 홍길동 : 모두삭제(Delete)
		//2. 김유신 ---> 김유신2 모두 수정(Update)
		
		//list1.remove(new Integer(5))
		System.out.println("삭제전 size : " + list.size());
		System.out.println("홍길동 삭제 전 : " + list);
		
		/* 뒤에서부터 검색하고 찾으면 삭제 처리 
		 // for문에 int i 시작점을 0으로 할경우 list.size()가 계속 줄어들기 때문에 모든 배열의 값을
		  * 확인하지 못한다. 하지만 list.size()를 변수를 사용하여 기준으로 시작점을 잡으면
		  * 배열값이 줄어들때마다 size도 줄어들기 때문에 모든 배열의 값을 확인할 수 있다.  
		int lastIdx = list.size() - 1;
		for(int i = lastIdx; i>=0; i--) {
			System.out.println(i + "삭제중 size : " + list.size());
			if (list.get(i).equals("홍길동")) {
				System.out.println(i + " : " + list.get(i));
				list.remove(i);
					
			}
		}
		--------------------------------------------------*/
		//System.out.println("list.remove(\"홍길동\") : " + list.remove("홍길동"));
		
		/* 찾아서 삭제할 수 없을 때까지 삭제 반복처리
		while (list.remove("홍길동")) {
		}
		*/
		
		/*while (true) {
			if (list.contains("홍길동")) { //데이터가 있냐?
				list.remove("홍길동");
			} else {
				System.out.println(">> 삭제완료(작업끝)");
				break;
			}
		}
		------------*/
		System.out.println("list.indexOf(\"홍길동\") : " + list.indexOf("홍길동"));
		System.out.println("list.indexOf(\"ABC\") : " + list.indexOf("ABC"));
		
		
		while (true) {
			int idx = list.indexOf("홍길동");
			if (idx == -1) { //데이터가 없냐?
				System.out.println(">> 삭제 완료(작업끝)");
				break;
			} else {
				list.remove(idx);
			}
		}
		
		
		
		
		
		
		
		
		
		

		System.out.println("홍길동 삭제 후 : " + list);
		System.out.println("삭제후 size : " + list.size());
		
		System.out.println("=== 김유신 ---> 김유신2 모두 수정 ===");
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("김유신")) {
				list.set( i, "김유신2");
				
			}
		}
		System.out.println("김유신 수정후 : " + list);
		
		
		
		
		
		
		
	}
	
	

}
