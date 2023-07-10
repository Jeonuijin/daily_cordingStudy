
public class Ex05_for_exam {

	public static void main(String[] args) {
		// 문제 : 1~10까지의 숫자중 짝수 출력
		
		//(실습) 1~10까지의 숫자중 3의 배수인 숫자를 출력
		
		//(실습) 900~1000까지의 숫자 중 17의 배수를 출력
		
		//(실습) 2000~3000까지의 숫자중 19의 배수를 출력
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0)  continue;
			 System.out.println("2의 배수 : " + i);
		}
		System.out.println("------------------");	
			
		for (int i = 1; i <= 10; i++) {
			if (i % 3 != 0) continue;
			System.out.println("3의 배수 : " + i);
		}
		System.out.println("------------------");	
		
		for (int i = 900; i <= 1000; i++) {
			if (i % 17 != 0) continue;
			System.out.println("17의 배수 : " + i);
		}	
		System.out.println("------------------");	
		
		for (int i = 2000; i <= 3000; i++) {
			if (i % 19 != 0) continue;
			System.out.println("199의 배수 : " + i);
			}
		System.out.println("=================");	
		
		int startNum = 1000;
		int endNum = 2000;
		int divNum = 199;
		
		for (int i = startNum; i <= endNum; i++) {
			if (i % divNum == 0) {
			System.out.println("199의 배수 : " + i);
			}
		
		}
	}
}

	
		
		
		
		
		
		



