package com.mystudy.innerclass;

public class StaticClassTest {
	int a = 100;
	private int b = 100;
	static int c = 200;
	
	static int sum = 0;
	static int sNum1 = 20;
	static int sNum2 = 20;
	
	
	static void sum() {
		sum = Inner.d + sNum2; 
		//sum = a + b;  a와 b는 static이 아니기 때문에
		//static메소드 안에서 사용할수 없음(생성시점이 다름)
	}
	
	//스태틱(static) 내부 클래스
	static class Inner {
		static int d = 1000;
		int e = 2000; // non-static
		
		void printData() { // non-static 메소드지만 클래스가 static
			//System.out.println("외부 int a : " + a);
			System.out.println("외부 static int c : " + c);
			System.out.println("내부 static int d : " + d);
			System.out.println("내부 static int e : " + e);
		
			System.out.println("외부 static int sum : " + sum);
			
		}
	}

	public static void main(String[] args) {
		int num = StaticClassTest.c; //c는 static이 붙어있기 때문에 객체 생성 안해도 쓸 수 있다.
		
		// static 내부클래스ㅢ static 필드변수 사용
		int innerNum = StaticClassTest.Inner.d;

		//static 내부클래스의 객체(인스턴스) 생성 후 printData() 호출(실행)
		StaticClassTest.Inner inner= new StaticClassTest.Inner();
		inner.printData();
	}

}
