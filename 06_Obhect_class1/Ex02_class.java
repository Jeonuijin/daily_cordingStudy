package edu.class1.basic;

// 클래스 선언부
// 클래스 내부에 작성하는 내용 : 변수선언, 생성자, 메소드 선언
public class Ex02_class {
	//============= 변수 선언 영역 ============
	//필드변수(인스턴스변수, 멤버변수, 속성-property, 전역변수)
	int num = 111;
	
	//클래스변수, 스테틱(static)변수, 인스턴스(객체) 공통변수(의미상)
	static int staticNum = 222;
	
	//============= 생성자 선언 영역 ===========
	Ex02_class() {} // 기본생성자(default constructor)생략가능

	
	//============= 메소드 선언 영역 ===========
	// main 메소드
	public static void main(String[] args) {
		// 지역변수(local variable)
		int num1 = 300;
		//System.out.println(num); //non-static 변수 접근못함
		System.out.println(staticNum);
		
		Ex02_class ex02 = new Ex02_class();
		System.out.println(ex02);
		System.out.println(ex02.num);
		System.out.println(staticNum);
		System.out.println("-------------");
		
		int result = add(100, 200);
		System.out.println("add(100, 200) 의 결과 : " + result);
		System.out.println("add(300, 500) 의 결과 : " + add(300, 500));
	}
	
	static int add(int a, int b) {
		return a + b;
	}
	
	

	
	
}
