package com.mystudy.thread03_error;

class ATM implements Runnable {

	int money;
	public ATM () {}
	public ATM (int money) {
		this.money = money;
	}
	
	// 입금처리
	// synchronized 처리로 사용중인 자원(필드값)에 대한 동기화 처리
	// 사용중에 다른 쓰레드에서 사용하려고 할 때 대기상태가 됨
	synchronized void add(int money) { 
		this.money += money;
		System.out.println(Thread.currentThread() + " - "
				+ "입금 : " + money + ", 잔액 : " + this.money);
	}
	
	// 출금처리
	synchronized void out(int money) { 
		this.money -= money;
		System.out.println(Thread.currentThread() + " - "
				+ "출금 : " + money + ", 잔액 : " + this.money);
	}
	
	@Override
	public void run() {
		// 입금 후 계속 출금
		add(1000);
		banksleep(1000);
		out(500);
		banksleep(1000);
		out(300);
		banksleep(1000);
		out(200);
		// 입금 조작 하는 중에 다른 사람이 데이터를 쓸수 있게 함
	}
	
	public void banksleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ATM_Thread_Error_Sync {

	public static void main(String[] args) {
		System.out.println("==== main() 시작 ====");
		ATM bank = new ATM();
		System.out.println("은행잔고 : "+ bank.money);
		
		Thread th1 = new Thread(bank);
		Thread th2 = new Thread(bank);
		
		th1.start();
		th2.start();
		
		
		System.out.println("==== main() 끝 ====");
		
	}

}
