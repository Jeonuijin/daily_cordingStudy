package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam1 {

	public static void main(String[] args) {
		// Scanner클래스 : 콘솔(화면)에서 데이터 읽어오기
		Scanner scan = new Scanner(System.in);// System에 있는 in은 static 변수
		
//		System.out.print("문자열 입력1 : ");
//		String str1 = scan.nextLine();
//		System.out.println(">>> " + str1);
//		
//		System.out.println("문자열 입력2 :");
//	    String str2 = scan.nextLine();
//		System.out.println(">>>" + str2);
//		
//		System.out.println("=====================");
//		System.out.println("정수값 2개를 입력하면 더한 결과 출력");
//////		int num1 = 10;
//////		int num2 = 20;
////		int sum = num1_+ num2;
//		int sum = 0;
//		//(주의) nextXxx 메소드 사용 후 nextLin() 사용 시 문제발생
//		
//		System.out.print("숫자입력1 :");
//		int num1 = scan.nextInt(); /// 줄바꿈(엔터) 문자까지의 값을 읽어서 처리
//		scan.nextLine(); // 줄바
//		
//		System.out.print("숫자입력2 :");
//		//int num2 = Integer.parseInt(scan.nextLine()); // **해결방법 1
//		int num2 = scan.nextInt(); // 줄바꿈(엔터) 문자까지의 값을 읽어서 처리(이미 값을 읽었기 때문에 입력을 받지 않음)
//		scan.nextLine(); // **해결방법 2 : 남아있는 개행 문자를 소비하기 위해 호출
//		
//		sum = num1 + num2;
//		System.out.println("합계 : " + sum);
//		
//		System.out.print("문자열(nextLine) : ");
//		String temp = scan.nextLine();
//		System.out.println("입력문자열 : " + temp);
//		
////		System.out.println();
////		System = System클래스
////		out = static변수 + 참조형 데이터
////		pringtln = 메소드
		
		System.out.println("=======================");
		System.out.println("문자열 1개와 정수 숫자3개 연속입력 : ");
		String strTemp = scan.next();
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		System.out.println("첫번째 문자열 : " + strTemp);
		System.out.println(n1 + ", " + n2 + ", " + n3);
	}

	
}

