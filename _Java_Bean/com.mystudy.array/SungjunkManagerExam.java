package com.mystudy.array;

public class SungjunkManagerExam {

	public static void main(String[] args) {
		// 2차원 배열을 사용한 성적 처리
		// 국어, 영어, 수학 점수 3개를 저장한 2차원 배열(sungjuk)을 만들고
		// 3명의 성적을 입력하고 개인별 총점과 평균을 계산 후 화면에 출력
		//--------------------------------------
		/*
		 국어\t영어 수학 총점 평균  ---> 총점과 평균은 출력만
		 ---------------------
		 100  90  80  270  90.0
		 100  90  81  271  90.33
		 100  90  82  272  90.66
		 ----------------------*/
		
		int[][] sungjuk= {{100, 90, 80},
						 {100, 90, 81},
						 {100, 90, 82}};
		String[] name = {"김유신", "홍길동", "이순신"};
		int[] tots = new int[sungjuk.length];
		double[] avgs = new double[sungjuk.length];
		
		//1번째 사람 데이터 처리 -----
		System.out.println("       국어\t영어\t수학\t총점\t평균");
		for (int i = 0; i < sungjuk.length; i++) {
		int kor = sungjuk[i][0];
		int eng = sungjuk[i][1];
		int math = sungjuk[i][2];
		 
		//계산처리
		int tot = kor + eng + math;
		double avg = tot * 100 / 3 / 100.0;
		
		//화면출력
		System.out.print(name[i] + " : ");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
		
		}
		
		System.out.println("=== 김유신 성적 화면출력 ===");
	
		
		
//		String[] name = new String[] {"국어", "영어", "수학", "합계", "평균"};
//		
//		for (int i = 0; i < name.length; i++) {
//			System.out.print(name[i] + " ");
//		}
//		System.out.println();
//		
//		for (int idx = 0; idx < sungjuk.length; idx++) {
//			int tot = 0;
//			for (int i = 0; i < sungjuk.length; i++) {
//				System.out.print(sungjuk[idx][i] + "  ");
//				tot = tot + sungjuk[idx][i];
//			}
//			System.out.print(tot + " ");
//			System.out.print(tot * 100 / 3 / 100.0);
//			System.out.println();
//		
//		}
//		
		
	}

}
