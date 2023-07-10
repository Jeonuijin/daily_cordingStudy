package edu.class1.basic;

public class Ex03_method {

	
	public static void main(String[] args) {
		int num1 = 500;
		int num2 = 200;
		int sum = 0;
		
		sum = add(num1, num2); //메소드 실행(호출)
		System.out.println("sum : " + sum);
		
		// static 영역에서 non-static 영역 접근시 객체(인스턴스)를 통해 사용해야 한다
		// 인스턴스(객체)를 사용하면 static, non-static 변수 모두 사용가능
		Ex03_method ex03 = new Ex03_method(); 
		System.out.println("sub : " + ex03.sub(num1, num2));
		System.out.println("mul : " + ex03.mul(num1, num2));
		System.out.println("div : " + ex03.div(num1, num2));
	}

	//메소드 선언(static)
	static int add(int a, int b) {
		return a + b;
	}
	
	// 메소드 선언(non-static)
	int sub(int a, int b) {
		return a - b;
	}
	
	int mul(int a, int b) {
		return a * b;
	}
	
	int div(int a, int b) {
		return a / b;
	}
	
	//=============================
	// 메소드 형태 : 파라미터 값 유무, 리턴값 유무
	void method1() {
		System.out.println("파라미터값 X, return 값 X");
	}
	
	void method2(String param) {
		System.out.println("파라미터 값 O, return 값 X");
	}
	
	String method3() {
		System.out.println("파라미터값 X, return 값 O");
		return "파라미터값 X, return 값 O";
	}
	
	String method4(String param) {
		System.out.println("파라미터 값 O, return 값 O");
		return "파라미터 값 O, return 값 O";
		
	}
}
