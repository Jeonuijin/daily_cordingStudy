package com.mystudy.scanner5_guess;

import java.util.Scanner;

public class GuessNumberGame_2 {
	private Scanner scan = new Scanner(System.in);
	
	public void startGame() {
		System.out.println("::: 게임을 시작합니다.");
		while (true) {
			playGame();	
			System.out.println("컴) 게임을 계속 하시겠습니까(y/n))? ");
			if ("n".equalsIgnoreCase(scan.nextLine())) {
				break;
			}
		}
		System.out.println("::: 게임이 종료되었습니다.");
		
	}
	
	private void playGame() {
		System.out.println("--->> 게임 플레이 시작");
		//1. 컴퓨터가 1 ~ 100까지 숫자 중 하나를 선택
		int comNo = (int)(Math.random() * 100 + 1);
		System.out.println("컴) 1~100까지 숫자 중 하나를 생각했습니다. 5번 이내에 맞춰보세요~~~");
		System.out.println("> 컴퓨터가 생각한 숫자 : " + comNo);
		
		int min = 1;
		int max = 100;
		for (int i = 1; i <= 5; i++) {
			//2. 사람이 숫자를 선택
			int selectNumber = selectNumber(i, min, max);
			
			if (selectNumber < min || selectNumber > max) {
				System.out.println("컴) 범위 확인하고 다시 입력하세요~~");
				i--;
				continue;
			}
			
			//3. 사람선택 숫자와 컴퓨터 숫자 비교
			if (comNo == selectNumber) {
				System.out.println("컴) 성공!!! 맞췄습니다. " +
								 "내가 생각한 숫자는 : " + comNo);
				break;
			}
			if (comNo > selectNumber) {
				System.out.println("컴) " + selectNumber + " 보다 큽니다");
				min = selectNumber + 1;
			}
			if (comNo < selectNumber) {
				System.out.println("컴) " + selectNumber + " 보다 작습니다");
				max = selectNumber - 1;
			}
			// 5번 시도하고 여기까지 왔으면 실패
			if (i == 5) {
				System.out.println("컴) 실패!!! "
								+ "내가 생각한 숫자는 " + comNo + "입니다");
			}
		}
		System.out.println("---->> 게임 플레이 종료");
		
	}

	private int selectNumber(int tryCnt, int min, int max) {
		int number = -1;
		while (true) {
			try {
				System.out.println(tryCnt + "번째 숫자선택(" + min + "~" + max + ")");
				number = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("[주의] 숫자값을 입력하세요");
			}
		}
		return number;
	}
}
