package com.mystudy.array;

public class Ex04_array_swap {

	public static void main(String[] args) {
		// 변수값 서로 교환하기
		int a = 100;
		int b = 200;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("-----------------");
		//(실습) a와 b의 값을 서로 교환하기
		int c;
		int d;
		int temp;
		
		c = a; // a 값을 복사후
		a = b; // a가 값을 받는다
		b = c;
		
		System.out.println("-- 교환 후 결과 --");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("==========================");
		
		//			  0     1    2    3    4	5
		int[] nums2 = {100, 200, 300, 400, 500, 600};
		System.out.println("배열의 크기 : " + nums2.length);
		
		//배열 전체 데이터 화면출력
		
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i] + " ");
		}
		System.out.println();
		System.out.println("----------------");
		//배열 데이터를 뒤집기
//		c = nums2[0];
//		nums2[0] = nums2[5];
//		nums2[5] = c;
//	
//		c = nums2[1];
//		nums2[1] = nums2[4];
//		nums2[4] = c;
//		
//		c = nums2[2];
//		nums2[2] = nums2[3];
//		nums2[3] = c;
		

		
		for (int i = 0; i < nums2.length/2; i++) {
			temp = nums2[i];
			nums2[i] = nums2[nums2.length - (i + 1)];
			nums2[nums2.length - (i + 1)] = temp;
				
		}
	
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i] + " ");
		}
		
		//nums2 : {500, 400, 300, 200, 100};
		
		//위치 변경된 배열 데이터를 뒤집기
		
		


		
	}
	
	
}
