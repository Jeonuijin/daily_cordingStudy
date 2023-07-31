package com.mystudy.scanner5_bank;

import java.util.Scanner;

public class BankATM_2 {

	private int money;
	private Scanner scan = new Scanner(System.in);
	
	public void startBank() {
		
		System.out.println(">> ATM기 시작");
		while (true) {
			int select = runningATM();
			if (select == 0) {
				System.out.println("종료~~");
				break;
			}
		}
		System.out.println(">> ATM기 사용끝");

	}
	private int runningATM() {
		//메뉴표시
		showMenu();
		int select = -1;
		//메뉴선택
		try {
			select = scan.nextInt();
		} catch (Exception e) {
			System.out.println("[예외발생] 잘못된 값이 입력되었습니다. 메뉴(0~3) 숫자만 입력하세요.");
		}finally {
		scan.nextLine(); //줄바꿈 문자까지의 빈문자열("") 읽어서 처리(버림)
		}
		//선택작업 처리
		if (select == 1) {
			System.out.println("입금처리~~~");
			inputMoney();
		}
		if (select == 2) {
			System.out.println("출력처리~~~");
			outputMoney();
		}
		if (select == 3) {
			System.out.println("통장확인~~~");
			showMoney();
		}
		if (select == 0) {
			System.out.println("종료~~~");
		}
		return select;
		
	}
	private void inputMoney() {

		while (true) {
			try {
				System.out.println("입금액 : ");
				money += Integer.parseInt(scan.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("[예외발생] 잘못된 값이 입력되었습니다. 숫자(0~3) 숫자만 입력하세요.");
			}
		}

	}
	
	private void outputMoney() {
		System.out.println("출금액 : ");
		money -= Integer.parseInt(scan.nextLine());
	}
	
	private void showMoney() {
		System.out.println("통장 잔액 : " + money);
	}
	
	private void showMenu() {
		System.out.println("---------------------------");
		System.out.println("1.입금 2.출금 3.통장확인 0.종료");
		System.out.println("---------------------------");
		System.out.println(">작업선택 : ");
	}
}
