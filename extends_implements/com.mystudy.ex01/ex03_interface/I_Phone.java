package com.mystudy.ex03_interface;

// 인터페이스에는 final 속성값, 추상메소드가 있다
interface I_Phone { //public 있고, 없고
	// {} 없는 메소드 : 추상메소드(abstract method)
	// 인터페이스에 정의된 추상메소드는 모두 public abstract 메소드 //정의부만 있음 (구현부X)
	public abstract void view(); //전화정보 확인
	public void call(); // 전화걸기
	void receiveCall(); // 전화받기
	void sendSMS();
	void receiveSMS();
	
}
