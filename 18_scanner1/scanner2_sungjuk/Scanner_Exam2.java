package com.mystudy.scanner2_sungjuk;

import java.util.Scanner;

public class Scanner_Exam2 {

	private static final String String = null;

	public static void main(String[] args) {
		/* (실습) Scanner 사용 성적처리
		입력 : 성명, 국어, 영어, 수학 점수를 입력받아
		처리 : 총점, 평균 계산한다
		출력 : 결과를 화면 출력
		===(처리결과 출력예시)===
		성명 : 홍길동
		국어 : 100
		영어 : 90
		수학 : 81
		------------
		총점 : 271
		평균 : 90.33
		================= */
		Scanner scan = new Scanner(System.in);
		
		boolean a = true;
		
		while (a) {

			System.out.print("성명 : ");
			String name = scan.next();
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			System.out.print("수학 : ");
			int math = scan.nextInt();

			int tot = kor + eng + math;
			System.out.print("총점 : ");
			System.out.println(tot);

			double avg = (tot * 100 / 3 )/ 100.0;
			System.out.print("평균 : ");
			System.out.println(avg);
			System.out.println("------------");

			System.out.print(">>다음 성적처리(계속or끝) : ");
			String a1 = scan.next();

			if (a1.equals("끝")) {
				System.out.println("성적처리가 끝났습니다.");
				break;
			} else if (a1.equals("계속")) {
				continue;
			} 

		}
		
		
		
		}
	}


