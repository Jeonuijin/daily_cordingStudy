package com.mystudy.scanner2_sungjuk;

import java.util.Scanner;

//(개인별 실습) : StudentVO, List에 처리된 데이터 모아서 사용
public class ScannerSungjuk {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public void start() {
			Scanner scan = new Scanner(System.in);

		while (true) {
			//입력
			input(scan);
			
			//처리 : 총점, 평균
			process();
			
			//출력
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
	public void input(Scanner scan) {
		
		System.out.print("성명 : ");
		name = scan.next();
		System.out.print("국어 : ");
		kor = scan.nextInt();
		System.out.print("영어 : ");
		eng = scan.nextInt();
		System.out.print("수학 : ");
		math = scan.nextInt();
		
	}
	
	private void process() {
		//처리 : 총점, 평균 계산한다
		int tot = kor + eng + math;
		System.out.print("총점 : ");
		System.out.println(tot);

		double avg = (tot * 100 / 3) / 100.0;
		System.out.print("평균 : ");
		System.out.println(avg);
		System.out.println("------------");
	}
	
}


