package com.mystudy.phone;

public class view {

	public static void main(String[] args) {
		
		Phone p = new Phone();
		System.out.println("p : " + p);
		p.call();
		p.receiveCall();
		p.sendSms("안녕");
		p.view();
		
		System.out.println("==== phone2 ====");
		Phone p1 = new Phone("아이폰","터치",true);
		System.out.println("p1 : " + p1);
		p1.hsize = 5;
		p1.vsize = 15;
		p1.view();
		
		System.out.println("===Phone의 기능===");
		p1.call();
		p1.receiveCall();
		p1.sendSms(" : 안녕하세요");
		String receiveMsg = p1.receiveSms("메시지 받았습니다");
		System.out.println("받은 메시지 : " + receiveMsg);
	}

}
