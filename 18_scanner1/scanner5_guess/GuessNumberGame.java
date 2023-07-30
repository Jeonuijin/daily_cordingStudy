package com.mystudy.scanner5_guess;

import java.util.Scanner;

/* 숫자 추측 게임
	컴퓨터가 1~100 사이의 숫자를 정하면 사람이 맞추는 게임
	선택 기회 5회
	---------------------
	Math.random() : 0 <= random값 < 1 범위의 실수값 
	컴숫자 : 70 인 경우 
	  사람이 선택한 숫자(80)가 크면 : 생각한 숫자보다 작다는 메시지 출력
	  사람이 선택한 숫자(50)가 작으면 : 생각한 숫자보다 크다는 메시지 출력
	5번 이내에 맞추면 : 성공!!! n번 만에 맞췄습니다.(화면출력)
	5번을 넘기면 : 실패~~ 내가 생각한 숫자는 70입니다.(화면출력)
	-----
	다시 도전하시겠습니까?(y,n) 
	---------------------------
	*/



public class GuessNumberGame {
	static int random1;
	static Scanner scan = new Scanner(System.in);
	static int count;
	static int number;

	public static void main(String[] args) {

		while (true) {

			for (int i = 1; i <= 5; i++) {
				random1 = (int) (Math.random() * 99 + 1);
				if (i <= 4) {
					System.out.println(i + "번째 맞추기");
					startGame();
				} else if (random1 == number) {
					break;
				} else if (i == 5) {
					startGame1();
				}

			}

			System.out.println("숫자맞추기를 계속하시겠습니까? 1.예 2.아니요");

			String a1 = scan.next();
			if (a1.equals("2")) {
				System.out.println("게임이 종료되었습니다.");
				break;
			} else if (a1.equals("1")) {
				System.out.println(">>게임시작<<");
				continue;
			}
		}

	}

	static void startGame() {

		System.out.println("숫자 선택하기 : ");
		number = scan.nextInt();

		if (random1 < number) {
			count++;
			System.out.println("생각한 숫자보다 작습니다.");
			System.out.println();
		} else if (random1 > number) {
			count++;
			System.out.println("생각한 숫자보다 큽니다.");
			System.out.println();
			count++;
		} else if (random1 == number) {
			count++;
			System.out.println("성공 !! " + count + "번만에 맞췄습니다");
		}
	}

	static void startGame1() {
		System.out.println("마지막 기회");
		int number;

		Scanner scan = new Scanner(System.in);

		System.out.println("숫자 선택하기 : ");
		number = scan.nextInt();

		if (random1 < number) {
			count++;
			System.out.println("실패 내가 생각한 숫자는 : " + random1);
		} else if (random1 > number) {
			count++;
			System.out.println("실패 내가 생각한 숫자는 : " + random1);
		} else if (random1 == number) {
			count++;
			System.out.println("성공 !!" + count + " 번만에 맞췄습니다");
		}
	}
}