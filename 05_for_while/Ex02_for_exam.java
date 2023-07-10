
public class Ex02_for_exam {

	public static void main(String[] args) {
		// for (초기값설정 ; 실행(종결)조건 ; 증감설정) { }
		//(실습) 1 ~ 5까지의 숫자 화면출력(반복문)\
		//(실습) 11 ~ 15까지의 숫자 화면출력
		//(실습) 1, 3, 5, 7, 9 화면출력
		//(실습) 2, 4, 6, 8, 10 화면출력
		//(실습) 5, 4, 3, 2, 1 화면출력
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("---------------");	
		
		for (int i = 11; i <= 15; i++) {
			System.out.println(i);
		/* => 변수 설정하여서 for문 작성
		  int num = 11;
		  for (int i = 1; i <= 5; i++) {
		
				System.out.println(num++); 
		*/
		}
		System.out.println("---------------");	
		
		for (int i = 1; i <= 9; i += 2) {
			System.out.println(i);
		}
		System.out.println("---------------");	
		
		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("---------------");	
		
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
		
		
		
		
		
		
		
	}

}
