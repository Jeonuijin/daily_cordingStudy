package com.mystudy.array4_2dim;

import java.util.Arrays;

public class ArrayExam {

	public static void main(String[] args) {
		/* 문제 : 2차원 배열을 사용하여
		 int[][] num2dim = { {10,20}, {30,40}, {50,60} };
		 1. 2차원 배열 num2dim 값을 화면 출력 : 10 20 30 ...
		 2. num2dim 의 세번째 값인 30을 100으로 변경하고 화면출력(위치값)
		 3. num2dim 의 크기만큼 num2Copy 배열을 선언하고
		    num2dim ----> num2Copy 데이터 복사 후
		    num2Copy 데이터 화면출력
		 *** 데이터 복사 형태 확인 : 얕은복사(주소값복사), 깊은복사(물리적복사)
		 */

		int[][] num2dim = { {10, 20}, {30, 40}, {50, 60} };
		
//		num2dim[0] = new int[] {10,20};
//		num2dim[1] = new int[] {30,40};
//		num2dim[2] = new int[] {50,60};
		
		System.out.println("--- 2차원 배열 출력 ---");
		printData("num2dim", num2dim);
		
		System.out.println("--- 문제 2번 ---");
		num2dim[1][0] = 100;
		printData("30 -> 100 변경 후",num2dim);
		
//		int[][] num2Copy = num2dim.clone();	
//		printData(num2dim);
//		System.out.println();
//		System.out.println(num2dim == num2Copy);
		
		System.out.println("--- 문제 3번 ---");
		//int[][] num2Copy = new int[num2dim.length][];
		//num2Copy[0] = new int[num2dim[0].length];
		//num2Copy[1] = new int[num2dim[1].length];
		//num2Copy[2] = new int[num2dim[2].length];
		
		// clone(), copyOf() 등 복사기능 사용(개인별)
		
		int[][] num2Copy = num2dim.clone();	
		
		
		int[][] num2Copy1 = new int[num2dim.length][2];
		for (int idx = 0; idx < num2Copy1.length; idx++) {
			for (int i = 0; i < num2Copy1[idx].length; i++) {
				num2Copy1[idx][i] = num2dim[idx][i];
			}
		}
		printData("num2Copy",num2Copy1);
		System.out.println("데이터 복사형태 확인 : " + (num2dim == num2Copy1));
		System.out.println("num2dim[0] == num2Copy[0] : " + (num2dim[0] == num2Copy1[0]));
		System.out.println("num2dim[1] == num2Copy[1] : " + (num2dim[1] == num2Copy1[1]));
		System.out.println("num2dim[2] == num2Copy[2] : " + (num2dim[2] == num2Copy1[2]));
	}
	
	
	static void printData(String name,int[][] num) {
		System.out.print(name + " : ");
		for (int idx = 0; idx < num.length; idx++) {
			for (int i = 0; i < num[idx].length; i++) {
				System.out.print(num[idx][i]+ " ");
			}
		}
		System.out.println();
	}	
}
