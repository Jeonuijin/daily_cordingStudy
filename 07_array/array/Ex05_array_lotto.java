package com.mystudy.array;

import java.util.Arrays;

public class Ex05_array_lotto {

	public static void main(String[] args) {
		// 로또 번호 생성기
		// 1. int 타입의 숫자 45개를 저장할 수 있는 배열 선언 (balls)
		// 2. 초기화 : 1~45 까지의 숫자(번호)를 입력
		// 3. 충분히 많이 섞고 --> 반복문
		// 4. 6개 번호를 추출(앞에서 부터 6개 사용)
		//---------------------------------------------
		// 0 - 44 임의의 숫자를 만들어내기(랜덤)
		// 임의의 숫자와 맞교환
	
		//랜덤한 값(숫자) 만들기 - Math.random() : 0 <= double < 1
		//	System.out.println(Math.random() * 45); : 0~44까지의 랜덤한 값 생성
	
		//		for (int i = 0; i < 100000; i++) {
		//			System.out.println((int)(Math.random() * 3));
		//		}
		//		System.out.println("------------");
		
        // 배열선언
		int[] balls = new int[45];
		
		// 저장된 데이터 확인(설정된 초기값 확인)
		System.out.println("---- 설정된 초기값 확인 ----");
		for (int i = 0; i < balls.length; i++) {
			balls[i] = i + 1;
			System.out.print(balls[i] + " ");
		}
		
		// 충분히 섞기
		int n;
		int a;
		
		for (int i = 0; i < 1000; i++) {
			n = (int)(Math.random() * 45); // 난수(랜덤값)
			a = balls[0];
			balls[0] = balls[n];
			balls[n] = a;	
		}
		System.out.println();
		System.out.println("=== 6개 번호 추출 ===");
		
		for (int i = 0; i < 6; i++) {
			System.out.print(balls[i] + " ");
		}
		
		for (int i = 0; i < 6; i++) {
			i = (int)(Math.random() * 45);
			System.out.print(" + 보너스 " + balls[i] + " ");
		}
		System.out.println();
		
		//======================
		System.out.println("---- 당첨번호 별도 저장하기 ----");
		int[] lottoNums = new int[6];
		
		for (int i = 0; i < 6; i++) {
			lottoNums[i] = balls[i];
		}
		System.out.println("balls : " + Arrays.toString(balls));
		System.out.println("lottoNums : " + Arrays.toString(lottoNums));
		
		System.out.println("==== Arrays.sort() 정렬처리 ====");
		//로또번호 오름차순 정렬
		Arrays.sort(lottoNums);
		System.out.println("lottoNums : " + Arrays.toString(lottoNums));
		
	}

}
