package com.mystudy.thread04_error2;

class Bank {
	int money = 0;
}

class ATM extends Thread {
	Bank bank;
	
	public ATM() {}
	public ATM(Bank bank) {
		this.bank = bank;
	}
	
	// 입금처리
	synchronized void add(int money) {
		bank.money += money;
		System.out.println(Thread.currentThread() + "-" +
					"입금 : " + money + ", 잔액" + bank.money);
	}
	
	// 출금처리
	
	synchronized void out(int money) {
		bank.money -= money;
		System.out.println(Thread.currentThread() + "-" +
					"출금 : " + money + ", 잔액" + bank.money);
	}
	
	@Override
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);
		
	}
	
	void bankSleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);//1초간격으로 출력늦추기
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
}

public class ATM_Thread_Error {

	public static void main(String[] args) {
		System.out.println("=== main()시작 ===");
		Bank bank = new Bank();
		
		ATM atm1 = new ATM(bank);
		atm1.start();
		

		ATM atm2 = new ATM(bank);
		atm2.start();
//		System.out.println("은행잔고 : " + bank.money);
//		
//		 Thread th1 = new Thread(bank);
//		 Thread th2 = new Thread(bank);
//		 th1.start();
//		 th2.start();
//		
		
		System.out.println("=== main()끝 ===");
	}

}
