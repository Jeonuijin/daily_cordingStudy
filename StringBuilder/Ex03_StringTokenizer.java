package com.mystudy.stringbuilder;

import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		// String 클래스의 split() vs StringTokenizer 클래스
		System.out.println("---- String split() ----");
		String str = "사과,배,복숭아, ,포도";
		System.out.println("str : " + str.toString());
		
		String[] strSplit = str.split(","); //빈문자열도 split은 데이터로 갖는다.
		System.out.println("strSplit.length : " + strSplit.length);
		
		System.out.println("--- str.split(\",\") 실행결과 배열 ---");
		for (int i = 0; i < strSplit.length; i++) {
			System.out.println(i + ":-" + strSplit[i] + "-");
		}
		System.out.println();
		
		System.out.println("--- 개선된 for문으로(또는 forEach) ---");
		for (String str2 : strSplit) {
			System.out.println("-" + str2 + "-");
		}
		System.out.println();
		
		int idx = 0;
		for (String str2 : strSplit) {
			System.out.println(idx++ + ": -" + str2 + "-");
		}
		
		System.out.println("\n====== StringTokenizer======");
		str = "사과,배,복숭아,,포도";
		System.out.println("str : " + str);
	
		StringTokenizer strToken = new StringTokenizer(str,",");
		System.out.println("strToken.countToken : " + strToken.countTokens());	
	
		while (strToken.hasMoreTokens()) {
			String token = strToken.nextToken();
			System.out.println(token);
		}
		// (주의) 토큰이 없을 때 nextToken() 사용하면
		//NosuchE1ementException 예외발생
		System.out.println("strToken.countToken : " + strToken.countTokens());

		System.out.println("============================");
		System.out.println("---(실습) 토큰데이터 for문으로 화면 출력---");
		
		strToken = new StringTokenizer(str,",");
		int tokenCnt = strToken.countTokens();
		
		for (int i = 0; i < tokenCnt; i++) {
			String token = strToken.nextToken();
			System.out.println(i + " : " + token);
			System.out.println("토큰갯수 : " + strToken.countTokens());

		}
	
		
		
		
	}
	

}
