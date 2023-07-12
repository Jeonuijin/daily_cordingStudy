package com.mystudy.stringbuilder;

public class Ex01_StringBuffer {

	public static void main(String[] args) {
		// StringBuffer 클래스
		StringBuffer sb = new StringBuffer("Hello Java!!!");
		System.out.println(sb);
		String str = sb.toString(); //StringBuffer 의 저장 문자열 확인
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		System.out.println("--- String : 데이터 불변(immutable) ---");
		String str1 = sb.toString();
		System.out.println("str1 : " + str1);
		String str2 = str1.concat(" 반갑습니다");
		System.out.println("str2 : " + str2);
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("--------------------");
		
		System.out.println("--- StringBuffer : 데이터 변경가능 ---");
		System.out.println("sb : " + sb.toString());
	
		sb.append(" 반갑습니다").append("~~~");
		System.out.println("append 후 sb : " + sb.toString());
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		sb.reverse();
		System.out.println("append 후 sb : " + sb.toString());
		sb.reverse();
		System.out.println("append 후 sb : " + sb.toString());
		
		System.out.println("==== delete(), insert(), replace() ====");
		//Hello Java!!! 반갑습니다~~~
		StringBuffer sb2 = sb.delete(0, 6);
		System.out.println("sb.delete(0, 6) : " + sb.delete(0, 6));
		System.out.println("sb : " + sb.toString());
		System.out.println("sb == sb2 : " + (sb == sb2));
	}

}
