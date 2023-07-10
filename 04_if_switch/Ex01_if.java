
public class Ex01_if {

	public static void main(String[] args) {
		/* 제어문 - 분기문(비교문) : if 문
		 if () {
		  	실행할 문장들(조건이 참일때)
		 }
		*/
		int num1 = 10;
		int num2 = 20;
		System.out.println("num1 < num2 : " + (num1 < num2));
		if (num1 < num2) {
			System.out.println("num1이 num2보다 작다");
		}
		System.out.println(">> 비교작업 끝");
		
		boolean result = num1 < num2;
		if (result) {
			System.out.println("num1이 num2보다 작다");
		}
		System.out.println(">> 비교작업 끝2");
		System.out.println("=====================");
		
		// 점수 평가 결과 출력 : 수, 우, 미, 양, 가
		/*
		 90~100 : 수
		 80~89 : 우
		 70~79 : 미
		 60~69 : 양
		 0~59 : 가
		*/
		
		
		System.out.println("--- 성적처리 ---");
		String name = "홍길동";
		int jumsu = 75;
		String result2 = "평가안됨";
		
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + jumsu);
		
		// 평가작업
		if (jumsu >= 90 && jumsu <= 100) {
			//System.out.println(":: 평가결과 : 수");
			result2 = "수";
		}
		if (jumsu >= 80 && jumsu <= 89) {
			//System.out.println(":: 평가결과 : 우");
			result2 = "우";
		}
		if (jumsu >= 70 && jumsu <= 79) {
			//System.out.println(":: 평가결과 : 미");
			result2 = "미";
		}
		if (jumsu >=60 && jumsu <= 69) {
			//System.out.println(":: 평가결과 : 양");
			result2 = "양";
		}
		if (jumsu >=0 && jumsu <=59) {
			//System.out.println(":: 평가결과 : 가");
			result2 = "가";
		}
		System.out.println(":: 평가결과 : " + result2);
		
		System.out.println(">> 성적처리 끝-------");
		// 달라지는 부분은 변수처리한다 (수,우,미,양,가 같은 값부분)
		// 변수 사용범위는 중괄호 기준이다. (같은 중괄호 범위에 같은변수 사용불가능)
		// 지역변수는 값이 초기화되어있어야된다.
		
		
	}

}
