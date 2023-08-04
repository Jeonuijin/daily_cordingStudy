package com.mystudy.thread04_error2_syncObj;

class Bank {
   int money = 0;
}

class ATM extends Thread {
   Bank bank;

   public ATM() {
   }

   public ATM(Bank bank) {
      this.bank = bank;
   }

   // 입금작업
   // synchronized (사용객체) {} : 사용객체 (인스턴스) 동기화 처리
   void add(int money) {

      synchronized (bank) {
         bank.money += money;
         System.out.println(Thread.currentThread() + " - " + "입금 : " + money + ", 잔액 : " + bank.money);
      }

   }

   // 출금작업
   void out(int money) {
      synchronized (bank) {
         bank.money -= money;
         System.out.println(Thread.currentThread() + " - " + "출금 : " + money + ", 잔액 : " + bank.money);
      }
   }

   @Override
   public void run() {
      // 입금 후 계속 출금
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
         Thread.currentThread().sleep(millisecond);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

}

public class ATM_Thread_Error {

   public static void main(String[] args) {
      System.out.println("====== main() 시작 ======");
      Bank bank = new Bank();

      ATM atm1 = new ATM(bank);
      atm1.start();

      ATM atm2 = new ATM(bank); // atm1과 같은 통장을 이용
      atm2.start();

      System.out.println("====== main() 끝 ======");
   }

}