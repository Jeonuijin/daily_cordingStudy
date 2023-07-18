package com.mystudy.ex02_extends;

// 클래스 상속(extends:확장) 실습
/* Phone 클래스 상속 확장(extends)
 WebPhone 클래스 작성
 	- Phone 클래스 상속 확장해서 작성
 생성자 정의
  	- PhoneNo 전달받는 생성자
  	- type, phoneNo 전달받는 생성자
 기능 : 전화걸고, 받고, 전화정보보기, 웹검색 기능이 있는 전화기
 	웹검색기능
 	webSearch() : ">> WebPhone - 웹검색" 문구 화면 출력
 */
class WebPhone extends Mp3Phone {
	
	public WebPhone(String PhoneNo) {
		super(PhoneNo);
	}
	public WebPhone(String type, String PhoneNo) {
		super(type, PhoneNo);
	}
	
	public void webSearch() {
		System.out.println(">> WebPhone - 웹검색");
	}
	
}

