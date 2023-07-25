package com.mystudy.set1_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet_Lotto2 {

	public static void main(String[] args) {
		// Set을 이용한 로또 만들기 : 1~45 랜덤숫자 6개를 Set에 저장
		// 1. 로또번호 6개를 추첨해서 Set에 저장하고 화면 출력
		//	Math.random() : 0.0 ~ 0.999999.. 실수형 데이터 생성(0 <= ran <1)
		//	Math.random() 사용 : (int)(Math.random() * 45 + 1) // 2. 랜덤숫자 set에 저장
		// 2. 출력은 작은 숫자부터 큰 숫자 형태로 출력
		//	예) 금주의 로또번호 : 5, 8, 10, 25, 33, 41 //작은숫자부터 큰숫자형태로 출력
		//-------------------------------------------------------------
		//TreeSet<Integer> set = new TreeSet<Integer>();
		Set<Integer> set = new TreeSet<Integer>();
		
//		for(int i = 1; set.size() < 6 ;) { //6개가 될때까지
//			int ranNum = (int)(Math.random() * 45 + 1);
//			set.add(ranNum);
//		}
//		System.out.println("로또번호 : " + set);
//		
//		set.clear();
		
		while (set.size() < 6) {
			set.add((int)(Math.random() * 45 + 1));
			
		}
		System.out.println("로또번호 : " + set);
		
//		System.out.println("==== 오름차순 정렬 후 출력 ====");
//		ArrayList<Integer> lottoList = new ArrayList<>(set);
//		System.out.println("정렬전 lottoList : " + lottoList);
//		
//		Collections.sort(lottoList);
//		System.out.println("정렬후 lottoList : " + lottoList);
//	
		System.out.println("== 금주의 로또번호 발표 ==");
		System.out.print("금주의 로또번호 : ");
		boolean isFirst = true;
		for (Integer num : set) {
			if (isFirst) {
			System.out.print(num);
			isFirst = false;
			} else {
				System.out.print(", " + num);
			}
		}
		System.out.println();
	}

}
