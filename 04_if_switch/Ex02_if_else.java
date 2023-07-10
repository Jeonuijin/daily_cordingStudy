
public class Ex02_if_else {

	public static void main(String[] args) {
		// if 문 3종류
		// if (조건), {}
		// if (조건 {} else {}
		// if (조건 {} else if () {} else if () {} .... else {}
		//------------------------------------------------------
		int num1 = 10;
		int num2 = 50;
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		
		//1. if(조건) {}
		if (num1 > num2) {
			System.out.println("num1 > num2 : " + (num1 > num2));
			System.out.println("num1이 num2보다 크다");
		}
		if (num1 <= num2){
			System.out.println("num1이 num2보다 작거나 같다");
		}
		System.out.println(">> if () 끝");
		System.out.println("------------------------------");
		
		//2. if (조건) {} else {}
		if (num1 > num2) {
			System.out.println("num1이 num2 보다 크다");
		} else {
			System.out.println("num1이 num2보다 작거나 같다");
		}
		System.out.println(">> if ~ else 끝");
		System.out.println("-------------------------");
		
		//3. if (조건) {} else if () {} else if () {} .... else {}
		num1 = 30;
		num2 = 50;
		System.out.println("num1: " + num1 + ", num2 : " + num2);
		
		if (num1 > num2) {
		System.out.println("num1이 num2보다 크다");
		} else if (num1 == num2) {
			System.out.println("num1은 num2와 동일하다");	
		} else { //작은경우
			System.out.println("num1이 num2 보다 작다");
		}
		
		System.out.println(">> if ~ else if ~ else 끝");
		System.out.println("=======================");
		
		// 점수 평가 결과 출력 : 수, 우, 미, 양, 가
		/*
		90~100 : 수
		80~89 : 우
		70~79 : 미
		60~69 : 양
		0~59 : 가
		*/
		//3. if (조건) {} else if () {} else if () {} .... else {}
		System.out.println("---- 성적처리 ----");
		// 입력-----------
		String name = "홍길동";
		int jumsu = -75;
		String result2 = "평가안됨";
		
		// 처리-----------------
		if(jumsu <0 || jumsu>100) {
			result2 = "잘못된 점수";
		} else if (jumsu>=90) {
			result2 = "수";
		} else if (jumsu >=80) {
			result2 = "우";
		} else if (jumsu>=70) {
			result2 = "미";
		} else if (jumsu>=60) {
			result2 = "양";
		} else {
			result2 = "가";
		} 
	
		// 출력-------------
		System.out.println("홍길동의 평가결과 :" + result2);
		System.out.println("----성적처리 끝----");
		
		//===============================
		/* if문 내에 중첩해서 if문 얼마든지 사용가능
		 if () {
		 	if () {
		 		if () {
		 		} else {
		 		}
		 	}
		 } else {
		 	if () {
		 	} else if () {
		 	}
		
		 }
		 */
		
		
		
		
	}
}
