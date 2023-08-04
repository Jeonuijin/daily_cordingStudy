package com.mystudy.thread01;

class Parent {
	void print() {
		System.out.println("나는 Parent 클래스");
	}
}

// 다른 클래스를 상속확장한 경우 Thread 클래스를 상속받을 수 없음 
// 쓰레드로 만들기 위해서는 Runnable 인터페이스를 구현(implements)해서 만든다.
class RunnableImpl extends Parent implements Runnable{

	@Override
	public void run() {
		super.print();
		System.out.println("RunnableImple run() : Runnable 인터페이스 구현");
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
}

public class RunnableImplThread {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---------");
		
		// Runnable 인터페이스를 구현한 객체를 쓰레드로 사용하기 위해서는
		// Thread로 만들어야 하므로 Thread 클래스 객체를 생성해서 사용한다.
		RunnableImpl runnableImpl = new RunnableImpl();
		//runnableImpl.run();
		
		// Thread 클래스의 생성자에 Runnable 구현객체를 주입해서 생성
		Thread th1 = new Thread(runnableImpl);
		System.out.println(th1);
		th1.start();
		
		System.out.println("--- main() 끝 ---------");

	}

}
