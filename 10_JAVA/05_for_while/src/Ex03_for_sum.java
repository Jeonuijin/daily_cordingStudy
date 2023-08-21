
public class Ex03_for_sum {

	public static void main(String[] args) {
		// 문제 : 1~10 까지의 합계 구하시오(for, 화면출력)
		// 1~10 까지의 합계 : 55
		
		
		int sum = 0; //합계 저장할 변수(공간)
		
		for (int i = 1; i <=10; i++){
			sum = sum + i;  // sum += i;
		}
			System.out.println("1 ~ 10까지의 합계 : " + sum);
			System.out.println("------------------------");
			
			//(실습) 1 ~ 10까지의 숫자중에 짝수를 찾아서 출력(2, 4, 6, 8, 10)
			//(실습) 1 ~ 10까지의 숫자중에 홀수를 찾아서 출력(1, 3, 5, 7, 9)	
			
			
			
			
			for (int i = 1; i <= 10; i++) {
				if (i % 2 == 0) {  // 짝수냐?
					System.out.println("1 ~ 10 중 짝수 : " + i);
				}
			}
			
			System.out.println("===========================");
			
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0) {  // 홀수냐? 짝수가 아니냐?  =>  i % 2 == 0 도 가능
					System.out.println("1 ~ 10 중 홀수 : " + i);
				}
			}
			
	
	}

}
