package com.mystudy.ex02_extends;

// Phone 클래스를 상속받아(extends : 확장해서)
// Phone 허용된 속성, 기능을 사용 + Mp3Phone 속성, 기능 추가 사용
class Mp3Phone extends Phone {
	
	public Mp3Phone(String phoneNo) {
		//super(phoneNo);
		super("Mp3Phone 타입",phoneNo); //부모클래스 생성자 호출
	}
	
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo); //부모클래스 생성자 호출
	}
	
	//메소드(기능) --------------------
	public void playMusic() {
		System.out.println(">> Mp3phone - 음악플레이");
	}
	
	
}
