package com.mystudy.thread03_error;

class ATM_Error implements Runnable{
	int money;
	
	public ATM_Error() {}
	public ATM_Error(int money) {
		this.money = money;
	}
	//입금처리 
	void add(int money) {
		this.money += money;
		System.out.println(Thread.currentThread() + " - " +
		"입금 : " + money + "잔액 : " + this.money);
	}
	void out(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread() + " - " +
				"출금 : " + money + "잔액 : " + this.money);
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
	void bankSleep (int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
public class ATM_Thread_Error {

	public static void main(String[] args) {
		System.out.println("=====main() 시작=====");
		ATM_Error atm = new ATM_Error();
		System.out.println("은행잔고 : " + atm.money);
		
		Thread th1 = new Thread(atm);
		Thread th2 = new Thread(atm);
		
		th1.start();
		th2.start();
		
		System.out.println("=====main() 끝=====");

	}

}
