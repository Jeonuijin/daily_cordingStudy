package com.mystudy.ex01_random;

import java.util.Random;

public class Random_Exam2 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		System.out.println("---- nextInt() ----");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(ran.nextInt() + " ");
		}
		System.out.println();

		System.out.println("---- nextInt(5) ----");
		
		for (int i = 0; i < 20; i++) {
			int ranInt = ran.nextInt(5); // 0~4
			System.out.println(ran.nextInt(5) + " ");
		}
		System.out.println();
		
		System.out.println("====================");
		System.out.println(ran.nextDouble() + " - Random nextDouble");
		System.out.println(Math.random() + " - math.random()");
		
		
	}

}
