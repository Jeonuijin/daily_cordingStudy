package com.mystudy.string;

public class Ex01_String_basic {

	public static void main(String[] args) {
		// String 클래스 : 문자열 저장, 처리하기 위한 클래스(참조형 데이터 타입)
		// String 클래스 : 참조형 데이터 타입
		// String 데이터는 불변임(immutable)
		//------------------------------
		// 사용형식 2가지 
		// String str = "홍길동"; //기본 데이터 타입처럼 사용 가능
		// String str = new String("홍길동"); //객체(인스턴스) 생성
		//---------------------------------
		String str1 = "홍길동";
		String str2 = "홍길동";
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		// == : 객체(인스턴스, 주소값) 비교(동일 객체 여부 확인)
		System.out.println("str1 == str2 : " + str1.equals(str2));
		System.out.println("-------------------");
		
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");
		System.out.println("strOb1 : " + strObj1);
		System.out.println("strOb2 : " + strObj2);
		
		
		System.out.println("==== 문자열 값 비교 equals() 사용 ====");
		// equals() : 문자열 값을 비교할 떄는 반드시 equals() 사용할 것(반드시)
		System.out.println("str1 == strObj1 : " + (str1 == strObj1)); //같은 주소값이냐
		System.out.println("str1.equals(strObj12) : " + str1.equals(strObj1)); //같은 값이냐
		System.out.println("strObj1 == strObj2 : " + (strObj1 == strObj2));
		System.out.println("strObj1.equals(strObj2) : " + (strObj1.equals(strObj2)));
	}

}
