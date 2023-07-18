package com.mystudy.ex04_interface2;

class Mp3Phone extends Phone implements I_Mp3Phone{

	public Mp3Phone(String phoneNo) {
		super("Mp3Phone 타입", phoneNo);
		
	}
	
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
		
	}

	@Override
	public void playMusic() {
		System.out.println(">> 음악플레이~~~~");
		
	}
	
}
