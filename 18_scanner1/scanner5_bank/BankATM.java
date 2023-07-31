package com.mystudy.scanner5_bank;

import java.util.InputMismatchException;
import java.util.Scanner;

// 은행의 ATM
// 1. 입금	2. 출금	3. 통장확인	0. 종료
public class BankATM {
	private int money; //통장계좌 금액
	Scanner scan = new Scanner(System.in);

/*
-----------------------------------
1. 입금	2. 출금	3. 통장확인	0. 종료
-----------------------------------
>작업선택 : 1
>입금액 : 10000
-----------------------------------
1. 입금	2. 출금	3. 통장확인	0. 종료
-----------------------------------
>작업선택 : 3
>통장금액 : 10000 원
-----------------------------------
1. 입금	2. 출금	3. 통장확인	0. 종료
-----------------------------------
>작업선택 : 2
>출금금액 : 5000
-----------------------------------
1. 입금	2. 출금	3. 통장확인	0. 종료
-----------------------------------
>작업선택 : 3
>통장금액 : 5000 원
-----------------------------------
1. 입금	2. 출금	3. 통장확인	0. 종료
-----------------------------------
>작업선택 : 0
>작업을 종료합니다.
*/

	public void startBank() {

	System.out.println("===은행===");

	while (true) {

		System.out.println("---------------------------");
		System.out.println("1.입금 2.출금 3.통장확인 0.종료");
		System.out.println("---------------------------");
		System.out.println("작업 선택 : ");

		int number = -1;
		//메뉴선택
		try {
			number = scan.nextInt(); // nextInt를 인트타입으로 바꿔서 한번 해보기
		} catch (Exception e) {
			System.out.println("[예외발생] 잘못된 값이 입력되었습니다. 메뉴(0~3) 숫자만 입력하세요.");
		}
		scan.nextLine(); //nextInt로 하면 오류발생
		
		/*
		 * 사용자가 nextInt()를 호출하여 정수를 입력한 후 엔터를 누르면 입력 버퍼에 개행 문자('\n')가 남아 있게 됩니다.
문제는 이후에 nextLine()을 호출할 때 발생합니다. 
nextLine()은 입력 버퍼에서 개행 문자를 만날 때까지 입력을 읽어들이기 때문에, 
남아있는 개행 문자를 만나게 되면 바로 그 다음 라인으로 인식하고 입력을 받지 않게 됩니다. 
즉, nextInt() 다음에 nextLine()을 사용하면 nextInt()에서 입력받은 값 뒤에 아무런 입력을 받지 않고 그냥 넘어가게 됩니다.
		 */
		
		if (number == 1) {
			System.out.println("입금금액 : ");
			money += scan.nextInt();	
		}	
		if (number == 2) {
			System.out.println("출금금액 : ");
			money -= scan.nextInt();
		}
		if (number == 3) {
			System.out.println("통장확인 : " + money);
		}
		if (number == 0) {
			System.out.println("작업을 종료합니다.");
			break;
		}
		if (!(number >= 0 && number <= 3)) {
			System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요");
			continue;
		}
		System.out.println("서비스를 계속 이용하겠습니까? 1.Yes / 2.NO");
		int a = scan.nextInt();
		if (a == 2) {
			System.out.println("작업을 종료합니다.");
			break;
		}
	
		
	}
	}
}

