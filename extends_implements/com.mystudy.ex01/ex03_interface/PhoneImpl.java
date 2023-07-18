package com.mystudy.ex03_interface;

import com.mystudy.ex03_interface.I_Phone;

// 인터페이스를 구현(implements)해서 클래스 만들기
class PhoneImpl implements I_Phone{
	// @<---컴파일러가 읽고 해석하기 위한 주석
	
	@Override // 오버라이딩해서 만든 메소드 의미
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveSMS() {
		// TODO Auto-generated method stub
		
	}

}
