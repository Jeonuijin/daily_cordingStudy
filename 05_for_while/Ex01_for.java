
public class Ex01_for {

	public static void main(String[] args) {
		// 제어문 - 반복문(for, while, do ~ while)
		// for (초기값설정 ; 실행(종결)조건 ; 증감설정) { }
		// for (;;) {} //무한반복
		//-----------------------------------------
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("--------------");
		
		for (int i = 1; i<=3; i++) {
			System.out.println("*"); // 3번 반복
		}
		System.out.println("===============");
		
		// 별(*) 찍기를 10번 반복
		for (int i = 1; i <= 10; i++) {
			System.out.println("*");
		}
		System.out.println("--------------------");
		
		for (int i = 1; i <= 10; i += 2) {
			System.out.println("*");
		}
		//=============================================
		System.out.println("===== 1부터 5까지 출력=======");
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println("-------------------");
		
		/*
		 int num = 1;
		 System.out.println(num);
		 num++;
		 System.out.println(num);
		 num++;
		 System.out.println(num);
		 num++;
		 System.out.println(num);
		 num++;
		 System.out.println(num);		
		 num++;
		-------------------------------*/
		
		int num = 1;
		for (int i = 1; i <= 5; i++) {
			System.out.println("i : " + i);
			System.out.println(num++); 
		}
		System.out.println("---------------");
		// 반복인자 값을 사용해서 출력
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
			
		
	}

}
