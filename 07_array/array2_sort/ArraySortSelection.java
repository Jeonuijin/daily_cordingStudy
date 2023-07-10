package com.mystudy.array2_sort;

public class ArraySortSelection {

	public static void main(String[] args) {
		// 배열 숫자 데이터 정렬(Sort) - 오름차순(ASC), 내림차순(DESC)
		int[] num = {30, 20, 50, 40, 10};
		System.out.println("num : " + num);
		
		//데이터 확인
		System.out.println("원본데이터(num) : ");
		printData(num);
		
		System.out.println("=== 정렬시작 ===");
//		// 첫번째값(인덱스 0) vs 두번째값(인덱스 1)
//		if (num[0] > num[1]) {
//			int temp = num[0];
//			num[0] = num[1];
//			num[1] = temp;
//		}
//		printData(num);
//		
//		// 첫번째값(기준인덱스 0) vs 세번쨰값(인덱스 2)
//		if (num[0] > num[2]) {
//			int temp = num[0];
//			num[0] = num[2];
//			num[2] = temp;
//		}
//		printData(num);
//		
//		// 첫번째값(기준인덱스 0) vs 네번쨰값(인덱스 3)
//		if (num[0] > num[3]) {
//			int temp = num[0];
//			num[0] = num[3];
//			num[3] = temp;
//		}
//		printData(num);
//		
//		// 첫번째값(기준인덱스 0) vs 다섯번쨰값(인덱스 4)
//		if (num[0] > num[4]) {
//			int temp = num[0];
//			num[0] = num[4];
//			num[4] = temp;
//		}
//		printData(num);
//		
//		System.out.println("=== 반복문으로 변경 적용 ===");
//		//첫번째 값 기준 비교작업(인덱스 0 기준)
//		System.out.println("--- 기준인덱스 : 0 ---");
//		for (int i = 1; i < num.length; i++) {
//			if (num[0] > num[i]) {
//				int temp = num[0];
//				num[0] = num[i];
//				num[i] = temp;
//		}
//		printData(num);
//		}
//		
//		System.out.println("--- 기준인덱스 : 1 ---");
//		for (int i = 2; i < num.length; i++) {
//			if (num[1] > num[i]) {
//				int temp = num[1];
//				num[1] = num[i];
//				num[i] = temp;
//		}
//		printData(num);
//		}
//		
//		System.out.println("--- 기준인덱스 : 2 ---");
//		for (int i = 3; i < num.length; i++) {
//			if (num[2] > num[i]) {
//				int temp = num[2];
//				num[2] = num[i];
//				num[i] = temp;
//		}
//		printData(num);
//		}
//		
//		System.out.println("--- 기준인덱스 : 3 ---");
//		for (int i = 4; i < num.length; i++) {
//			if (num[3] > num[i]) {
//				int temp = num[3];
//				num[3] = num[i];
//				num[i] = temp;
//		}
//		printData(num);
//		}
//		
		System.out.println("===== 이중(중첩) for문으로 작성 =====");
		
		//기준인덱스 : 0 ~ 마지막 이전까지
		for (int a = 0; a < num.length - 1; a++) {
//			System.out.print("배열데이터(num) : ");
//			printData(num);
		
			for (int i = a; i < num.length; i++) {
				if (num[a] > num[i]) {
					int temp = num[a];
					num[a] = num[i];
					num[i] = temp;
			}
//			printData(num);
			}
		}
		
		System.out.println("정렬후 배열데이터(num) : ");
		printData(num);
		
			
		}


	static void printData(int[] num) {

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
	
	
}
