package com.mystudy.ex02_extends;

public class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체(인스턴스) 생성 후 기능 테스트
		System.out.println("=== Phone ===");
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		
		System.out.println("--------------------");
		Phone ph2 = new Phone("삼성갤럭시폰", "010-2222-2222");
		ph2.view();
		ph2.call();
		ph2.receiveCall();
		
		System.out.println("===== Mp3Phone =====");
		Mp3Phone mp3ph = new Mp3Phone("010-3333-3333");
		mp3ph.view();
		mp3ph.call();
		mp3ph.receiveCall();
		mp3ph.playMusic();

		System.out.println("==== WebPhone ====");
		WebPhone web = new WebPhone("아이폰","010-3333-3333");
		web.view();
		web.call();
		web.receiveCall();
		web.webSearch();
	
		System.out.println("==== MyPhone ====");
		MyPhone web1 = new MyPhone("아이폰2","010-4444-4444");
		web1.view();
		web1.call();
		web1.receiveCall();
		web1.webSearch();
		web1.playMusic();
	
	}

}
