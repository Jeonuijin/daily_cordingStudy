package com.mystudy.array;

public class Ex03_array_star {

	public static void main(String[] args) {
		 /* 별찍기
		 * 
		 **
		 *** 
		 ****
		 *****
		 --------------------------------*/
		// char 타입의 데이터를 5개 저장할 수 있는 배열을 만들고 별(*) 입력
		
		String[] ch = {"*", "*", "*", "*", "*"};

		for (int a = 1; a <= 5; a++) {
			for (int i = 0; i < a; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		System.out.println("========================");
		
		
		
		
	}

}
