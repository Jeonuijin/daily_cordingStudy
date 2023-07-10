
public class Ex05_max_number {

	public static void main(String[] args) {
		/* 숫자 3개 중 가장 큰 수를 구하시오
		 a: 30, b: 60, c: 20
		 <결과>
		 가장큰수 : 60
		 ----------------------------------*/

		int a = 30;
		int b = 60;
		int c = 20;
		int d = 15;
		int e = 70;
		int result = 0;
			
		
		if (a > b && a > c) {
			result = a;
		} else if (b > a && b > c) {
			result = b;
		} else if (c > a && c > b) {
			result = c;
		}
		System.out.println("가장 큰 수 : " + result);

		//-----------------------------------------------------
		if (a > b) { // a가 큰 경우
			if (a > c) {
				System.out.println("가장 큰 수 : " + a);
			} else {
				System.out.println("가장 큰 수 : " + c);
			}
		}else { // b가 큰 경우
			if (b > c) {
				System.out.println("가장 큰 수 : " + b);
			} else {
				System.out.println("가장 큰 수 : " + c);
			}
		}
		/* 숫자 3개 중 가장 큰 수를 구하시오
		 a: 30, b: 60, c: 20, d: 15, e: 70
		 <결과>
		 가장큰수 : 70
		 ----------------------------------*/
		
		System.out.println("====================");
		
		//int i = 0; //가장 큰 값 (데이터, 숫자)
		int i = Integer.MIN_VALUE; // 작은 값으로 초기값 설정
		
		if (a > i) {
			i = a;
		}
		if (b > i) {
			i = b;
		}
		if (c > i) {
			i = c;
		}
		System.out.println("가장 큰 수 : " + i);
		
	}

}
