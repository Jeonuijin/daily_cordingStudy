package com.mystudy.scanner4_scissors;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerGame {
	
//	public static void main(String[] args) {   //메소드 3번실행 (코드가 너무 길경우 따로 메소드로 빼내서 반복)
//		ScannerGame game = new ScannerGame();
//		for (int i = 0; i <= 3; i++) {
//			game.gameStart();
//		}
//	}

//	void method() {
//		System.out.println(">> method() 실행~~~");
//	}
	static Scanner scan = new Scanner(System.in);
	public static  int comWinCount = 0;
	public static int myWinCount = 0;

	public static void main(String[] args) {
		/*
		 * Scanner를 이용한 가위, 바위, 보 게임 scissors, rock, paper draw : 무승부, person_win,
		 * computer_win 컴퓨터가 가위(1), 바위(2), 보(3) 선택(Math.random()) 1.가위 2.바위 3.보 0.종료
		 * 선택메뉴 출력 선택값 입력 결과 비교 후 승자, 패자 결정 (반복) 게임 반복 진행 - 0 선택시 종료정리
		 */
		
		System.out.println("가위, 바위, 보 게임 시작 ~~!! >_<");
		System.out.println();

		int computer;
		int person;
		

		computer = (int) (Math.random() * 3 + 1);
		String strComputer = ChangetNumberToString(computer);
		
		System.out.println("컴퓨터는 가위,바위,보 중에 하나를 선택하였습니다");
		while (true) {
			
			person = selectPerson();
			
			String strPerson = "";
			switch (person) {		// switch문을 메소드로 생성해서 불러올 수 있다.
			case 1:
				strPerson = "가위";
				break;
			case 2:
				strPerson = "바위";
				break;
			case 3:
				strPerson = "보";
				break;
			}
			// 3. 결과 비교 후 승자, 패자 결정
			String result = "판정안됨";
			String lose = "사람 패, 컴퓨터 승";
			String win = "사람 승, 컴퓨터 패"; //반복되는 부분은 수정의 편의성을 위해 변수에 넣는다.
			
			if (strPerson.equals("종료")) {
				System.out.println("게임을 종료합니다.");
				break;
			}

			if (strPerson.equals(strComputer)) { // 따로 if 문으로 비긴경우를 작성하면 중복코드를 없앨수 있다.
				result = "비김";
			}

			if (person == 1 && computer == 2) {
				result = lose;
				comWinCount++;
			} else if (person == 1 && computer == 3) {
				result = win;
				myWinCount++;
			}

			if (person == 2 && computer == 1) {
				result = win;
				myWinCount++;
			} else if (person == 2 && computer == 3) {
				result = lose;
				comWinCount++;
			}

			if (person == 3 && computer == 1) {
				result = lose;
				comWinCount++;
			} else if (person == 3 && computer == 2) {
				result = win;
				myWinCount++;
			}

			/*
			 * // if문을 중첩하여 쓰는 방법도 있다. if(str.Computer.equals("보") { if
			 * (strPerson.equals("가위") { System.out.println("사람 승"); } if
			 * (strPerson.equals("바위") { System.out.println("컴퓨터 승"); }
			 */

			// 승/패 결과 출력
			System.out.println("person : " + strPerson + " computer : " + strComputer + "  =결과= : " + result);

			System.out.println();
			System.out.println("-----게임을 계속 하시겠습니까?(1.예 2.아니요)-------");

			String a1 = scan.next();
			if (a1.equals("2")) {
				System.out.println("게임이 종료되었습니다.");
				winCount();
				break;
			} else if (a1.equals("1")) {
				System.out.println(">>게임시작<<");
				winCount();
				continue;
			}
		}
	}

	// 총 이긴 수
	private static void winCount() {
		System.out.println("컴퓨터가 이긴 횟수 : " + comWinCount);
		System.out.println("내가 이긴 횟수 : " + myWinCount);
		System.out.println();

	}
	private static String ChangetNumberToString(int computer) {
		String str = "값없음";
		switch (computer) {
		case 1:
			str = "가위";
			break;
		case 2:
			str = "바위";
			break;
		case 3:
			str = "보";
			break;
		}
		
		return str;
		}
	
	private static int selectPerson() {  /// 값이 문자로 입력되었을떄를 위한 예외처리하기
		int result = -1;
		while (true) {
			try {
				System.out.println("1.가위 2.바위 3.보 0.종료 선택하기");
				result = Integer.parseInt(scan.nextLine());
				if (result >= 0 && result <= 3) {
					break;
				} else {
					System.out.println("::: 잘못된 선택 0~3 중에 선택하세요!!");
				}
			} catch (Exception e) {
				System.out.println("::: 잘못된 값 입력 숫자 0~3 중에 선택하세요!!!");
			}
		}
		return result;
	}
}
