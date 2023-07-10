
public class Ex06_for_star {

	public static void main(String[] args) {
		// ***** 화면출력
		System.out.println("*****");
		System.out.println("------------");
		
		System.out.print("*****");
		System.out.println(); //줄바꿈 역할
		System.out.println("------------");
		
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.println();
		System.out.println("------------");
		
		System.out.println("---- 반복문 print *(별) 찍기 반복 ----");
		for (int i = 1; i<=5; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.println("=================");
		/*
		*****
		*****
		*****
		------------------------------------- */
		for (int i = 1; i<=5; i++) {
			System.out.print("*");
		} //1번째 줄 
		System.out.println();
		for (int i = 1; i<=5; i++) {
			System.out.print("*");
		} //2번째 줄
		System.out.println();
		for (int i = 1; i<=5; i++) {
			System.out.print("*");
		} //3번째 줄
		System.out.println();
		for (int i = 1; i<=5; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.println("===== 반복 처리 =====");
		
		for (int line = 1; line <= 3; line++) {
			for (int i = 1; i<=5; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("===========================");
		
		for (int i = 1; i <= 3; i++) {
		System.out.print("*****");
		System.out.println();
		}
		System.out.println("-------------------");
	
		for (int i = 1; i <= 3; i++) {
			for (int star = 1; star <= 5; star++) {
				System.out.print("*");
			}
			System.out.println();
				}
		System.out.println("=======================");
		
		System.out.println("===== 삼각형 * 찍기 =====");
		/* 화면(콘솔창)에 삼각형 모양을 출력
		 *      1라인 : * 1개 + 줄바꿈      
		 **     2라인 : * 2개             
		 ***    3라인 : * 3개            
		 ****   4라인 : * 4개             
		 *****  5라인 : * 5개          
		 ------------------------------------*/
		int cnt = 0;
		
		for (int i = 1; i <= 5; i++) {
			for (int a = 0; a <= cnt; a++) {
				System.out.print("*");	
			}System.out.println();
			cnt++;
		}
		
		System.out.println("----------------");
	





	}
}



