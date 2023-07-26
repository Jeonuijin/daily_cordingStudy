package com.mystudy.scanner3_cafe;

import java.util.Scanner;

public class Scanner_Exam3_cafe {

	public static void main(String[] args) {
		// (실습) 카페 음료 주문 처리
		// 음료의 종류 :
		// 1.아메리카노(3000) 2.카페라떼(3500) 3.카페모카(4000) 4.과일주스(5000)
		// -------------------------------------
		// 입력값 : 메뉴번호, 주문수량, 입금액(고객이 낸 돈)
		// 출력값 : 입금액, 판매액(단가 * 수량), 잔돈(입금액 - 판매액)
		// ----------------------------------------
		/*
		 while (true) { //메뉴선택 0 선택시 종료
		 1.아메리카노(3000) 2.카페라떼(3500) 3.카페모카(4000) 4.과일주스(5000) 0.종료
		 > 메뉴를 선택하세요(1~4) : 1 //0 이면 끝
		 > 주문수량 : 3
		 > 입금액 : 10000
		 ================
		 입금액 : 10000
		 판매액 : 9000 
		 잔돈 : 1000
		 }
		 
		 또주문할래말래?
		 */
		int ame = 3000;
		int cafe = 3500;
		int moca = 4000;
		int juice = 5000;
		

		Scanner scan = new Scanner(System.in);
		
		while (true) {
		System.out.println("1.아메리카노 2.카페라떼 3.카페모카 4.과일주스");
		System.out.print("> 메뉴를 선택하시오(1~4) : ");
		int menu = scan.nextInt();
		
		System.out.print("> 주문수량 : ");
		int num = scan.nextInt();
		
		System.out.print("> 입금액 : ");
		int money = scan.nextInt();
		
		System.out.println("============");
		System.out.println("입금액 : " + money);
		
		//반복되는 if문을 for문으로 바꿀 수 있음
		if (menu == 1) {
		System.out.println("판매액 : " + ame * num);
		System.out.println("잔돈 : " + (money - (ame * num)));
		}else if (menu == 2) {
			System.out.println("판매액 : " + cafe * num);
			System.out.println("잔돈 : " + (money - (cafe * num)));
		}else if (menu == 3) {
			System.out.println("판매액 : " + moca * num);
			System.out.println("잔돈 : " + (money - (moca * num)));
		}else if (menu == 4) {
			System.out.println("판매액 : " + juice * num);
			System.out.println("잔돈 : " + (money - (juice * num)));
		}
		System.out.println("-----메뉴를 추가로 주문하시겠습니까?(예or아니요)-------");
		String a1 = scan.next();
		if (a1.equals("아니요")) {
			System.out.println("주문이 완료되었습니다.");
			break;
		} else if (a1.equals("계속")) {
			continue;
		} 
		}
		
	}

}
