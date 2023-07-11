package com.mystudy.string;

import java.util.Arrays;

public class Ex03_StringExam {

	public static void main(String[] args) {
		//String str = "901012-1234567"; //주민번호
		//1. 전체자리수 14개 여부확인, '-'위치: 7번째 여부 확인
		//2. 생년월일 출력(1-2:년도, 3-4:월, 5-6:일)
		//   예) 90년 10월 12일 또는 1990년 10월 12일
		//3. 성별 확인하고 출력(1,3: 남성, 2,4: 여성)
		//4. 데이터 값 검증(월: 1~12, 일: 1~31)
		//참고) int num = Integer.parseInt("10"); //"10" -> 10
		//---------------------------------------------------

		String str = "901012-1234567";
		
		if (str.length() == 14) {
			System.out.println("전체자리수 14개");
		}
		
		System.out.println(str.indexOf('-')+1);
		
		int a = Integer.parseInt(str.substring(0,2));
		int b = Integer.parseInt(str.substring(2,4));
		int c = Integer.parseInt(str.substring(4,6));
		int d = Integer.parseInt(str.substring(7,8));
		
		System.out.println(a + "년 " + b + "월 " + c + "일");		
		
		if (d == 1 || d == 3) {
			System.out.println("남성");
		} else if (d == 2 || d == 4){
			System.out.println("여성");
		}
		
		
		if (b >= 1 && b <=12) {
			System.out.println("월 단위 값이 정상입니다");
		} else {
			System.out.println("월 단위 값이 아닙니다");
		}
		
		if (c >= 1 && c <=31) {
			System.out.println("일 단위 값이 정상입니다");
		} else {
			System.out.println("일 단위 값이 아닙니다");
		}
		
		
		
		
	}
}
