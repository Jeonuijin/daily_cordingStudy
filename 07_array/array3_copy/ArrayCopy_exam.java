package com.mystudy.array3_copy;

import java.util.Arrays;

public class ArrayCopy_exam {

	private static int[] num;
	public static void main(String[] args) {
		/* 문제1 : int 타입의 데이터 4개를 저장할 수 있는 배열(num1)에
		 1. 10, 20, 30, 40 숫자를 입력하고 화면 출력
		 2. 세번째 데이터를 100으로 바꾸고 화면 출력 --> 위치
		 3. 20 숫자를 찾아서 99로 변경
		 -------------------------------------------*/

		/* 문제2 : num1과 크기가 같은 배열 num1Copy를 만들고
		  num1Copy에 num1 데이터를 복사하고 화면출력
		  주소값 복사인지 깊은복사(물리적 복사) 여부 확인
		 -------------------------------------------*/
		//문제1
		int[] num1 = new int[4];
		
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		num1[3] = 40;
		
		System.out.println("문제 1-1");
		printData("num1",num1);
		
		System.out.println("문제 1-2");
		num1[2] = 100;
		printData("num1",num1);
		
		
		System.out.println("문제 1-3");
		
		for (int i = 0; i < num1.length; i++) {
			if(num1[i] == 20) {
				num1[i] = 99;
			}
		}
		printData("num1",num1);
		
		
		System.out.println("문제 2");
		int[] num1Copy = new int[num1.length];
		
		for (int i = 0; i < num1.length; i++) {
			num1Copy[i] = num1[i];
		}
		
		printData("num1Copy",num1Copy);
		
		// 주소값 동일하냐? 동일객체냐?
		if(num1 == num1Copy) {
			System.out.println("num1, num1Copy : 동일주소, 동일객체");
		}else {
			System.out.println("num1, num1Copy : 다른주소, 별개의 다른객체");
		}
		
		System.out.println("=== 1차원배열 clone() 처리 ===");
		num1Copy = num1.clone();
		printData("num1Copy", num1Copy);
		System.out.println("num1 == num1Copy : " + (num1 == num1Copy));
		
		System.out.println("=== 1차원배열 Arrays.copyOf() 처리 ===");
		num1Copy = Arrays.copyOf(num1, num1.length);
		System.out.println("num1 == num1Copy : " + (num1 == num1Copy));
		
	}
	static void printData(String name, int[] num) {
		System.out.print(name + ": ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
		


		
	}
	

