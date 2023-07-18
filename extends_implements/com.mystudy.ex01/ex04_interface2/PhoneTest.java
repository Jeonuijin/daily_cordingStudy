package com.mystudy.ex04_interface2;

class PhoneTest {

	public static void main(String[] args) {
		System.out.println("==== Phone ====");
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		ph1.sendSMS();
		ph1.receiveSMS();
		System.out.println("getPhoneNo() : " + ph1.getPhoneNo());
		
		System.out.println("==== Mp3Phone ====");
		Phone ph2 = new Phone("010-2222-2222");
		ph2.view();
		ph2.call();
		ph2.receiveCall();
		ph2.sendSMS();
		ph2.receiveSMS();
		System.out.println("getPhoneNo() : " + ph2.getPhoneNo());

		
	
	
	}

}
