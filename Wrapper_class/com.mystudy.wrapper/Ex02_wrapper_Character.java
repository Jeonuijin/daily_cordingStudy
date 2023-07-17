package com.mystudy.wrapper;

public class Ex02_wrapper_Character {

	public static void main(String[] args) {
		// Character 클래스
		// "a" : String
		char ch = 'a';
		System.out.println(Character.isAlphabetic(ch)); //ch가 알파벳이냐? --> true
		System.out.println("Character.isAlphabetic('한') : " 
					+ Character.isAlphabetic('한')); //true
		
		System.out.println(Character.isLetter('0')); // false
		System.out.println(Character.isDigit('0')); // true
		System.out.println(Character.isLetter('A')); // true
		System.out.println(Character.isUpperCase('A')); //대문자냐 --> true
		System.out.println(Character.isLowerCase('A')); //소문자냐 --> false
		System.out.println(Character.isWhitespace(' ')); //시각적으로 보이지 않는 것 --> true
		System.out.println(Character.isWhitespace('\t')); // 탭 --> true
	
		
		System.out.println("--------");
		char[] chs = {'한', 'a', ' ', 'A', '+', '0'};
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + " : ");
			if(Character.isDigit(chs[i]));
				System.out.print("숫자 ");
		
		if (Character.isWhitespace(chs[i])) {
			System.out.print(("공백(제어문자) "));
		}
		if (Character.isUpperCase(chs[i])) {
			System.out.print(("대 "));
		}
		if (Character.isLowerCase(chs[i])) {
			System.out.print(("소 "));
		}
		if (Character.isLetter(chs[i])) {
			System.out.print(("문자 "));
		}
		if (Character.isDefined(chs[i])) {
			System.out.print(("유니코드문자 "));
		} //isDefined : 유니코드문자냐? 문자로 정의가 되어있냐
		
		System.out.println();
		}
	}
}
