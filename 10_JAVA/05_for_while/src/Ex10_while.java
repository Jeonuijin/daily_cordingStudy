
public class Ex10_while {

	public static void main(String[] args) {
		// 반복문 : while, do ~ while
		/* while 반복문 사용 형태
		 반복인자의 선언 및 초기값 설정;
		 while (실행조건식) {
		 	반복인자값 증감설정(선택적);
		 	실행문(들);
		 	반복인자값 증감설정(선택적);
		 }
		 -------------------------------*/
		//1~10 까지 화면출력
		for (int i = 1; i <=10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("-------------------");
		
		// while문으로 작성
		
		int i = 1;
		
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		System.out.println("-------------------");
		
		i = 0;
		while (i < 10) {
			i++;
			System.out.print(i + " ");	
		}
		System.out.println();
		System.out.println("-------------------");
		
		System.out.println("====== break, continue ======");
		// break : 현재 실행중인 반복문을 종료하고 빠져나감
		// while 무한반복
		
		int num = 1;
		while (true) {
			System.out.println(num);
			if (num >= 10) break; // 반복중단
			num++;
		}
		
		System.out.println("---- continume 문 ----");
		
		num = 0;
		while (num < 10) {
			num++;
			if (num == 5) continue; //증감식이 continue문 앞에 위치하도록 해야한다.
			System.out.println(num);
		}
		System.out.println("---- for continue ----");
		
		for (int m = 1; m <=10; m++) {
			if (m == 5) continue;
			System.out.println(m);
		}
		 
		System.out.println("===== do ~ while =====");
		// 반복문 : do ~ while 반복문 사용 형태
		/* 반복인자의 선언 및 초기값 설정;
		   do {
		 	실행문(들);
		 	반복인자값 증감설정(선택적);
		 	반복인자값 증감설정(선택적);
		 	}
		 	while (실행조건식)
		 -------------------------------*/
		
		//1 ~ 10 까지 출력
		num = 1000;
		
		do { 
			System.out.println("do~while : " + num);
			num++;
		} while (num <= 10);
		// do ~ while 문은 무조건 한번은 실행된다
		
		System.out.println("===========================");
		
		System.out.println("--- 내부 반복문에서 break 처리시 ----");
		for (int out = 1; out <= 3; out++) {
			System.out.println(":: out : " + out);
			
			for (int in = 1; in <= 5; in++) {
				System.out.println("out : " + out + ", in : " + in);
				if (out == 2) break; // 내부 반복문만 종료 처리됨
			}
			
			System.out.println("-----------------");	
		}
		System.out.println("=====================");
		
		System.out.println("==== 중첩 반복문 모두 중단하기 ====");
		//중첩 반복문을 모두 종료해야 하는경우 (위치지정 break문을 사용)
		//라벨지정
		outFor: for (int out = 1; out <= 3; out++) {
			System.out.println(":: out : " + out);
			
			for (int in = 1; in <= 5; in++) {
				System.out.println("out : " + out + ", in : " + in);
				if (out == 2) break outFor; // 외부반복문 중단처리
			}
			
			System.out.println("-----------------");	
		}
		System.out.println(">>> 프로그램 끝");
		
		
		
		
		
		
	}

}
