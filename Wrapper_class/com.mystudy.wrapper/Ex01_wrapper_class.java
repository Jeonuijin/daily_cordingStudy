package com.mystudy.wrapper;

public class Ex01_wrapper_class {

	public static void main(String[] args) {
		// wrapper class : 기본 데이터 타입의 기능확장한 클래스(들) 총칭
		// 기본 데이터 타입 : 전체소문자
		//	boolean, char, byte, short, int, long, float, double
		// wrapper class : 기본 데이터 타입의 첫글자를 대문자로
		// 	예외 : char -> Character, int -> Integer
		//	Boolean, Char, Byte, Short, Int, Long, Float, Double
		//-----------------------------
		int num = 100;
		System.out.println("num : " + num);
		
		Integer intNum = new Integer(100);
		//Integer intNum = new Integer(num);
		System.out.println("Integer intNum : " + intNum);
		
		String strNum = intNum.toString();
		System.out.println("String strNum : " + strNum);
		
		intNum = 900; // Integer <--- int : 자동형변환
		num = intNum; // int <--- Integer : 자동형변환

		num = Integer.parseInt("999"); // int <--- String 형변환
		intNum = Integer.valueOf("999"); //Integer <--- String 형변환
		
		String str = String.valueOf(999999); // String <--- int
		//valueOf와 toString 차이? --> num일때 다름 toString 은 오류가 남
		
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 최소값 : " + Integer.MIN_VALUE);
		
		System.out.println("--- boolean ---");
		Boolean bool = true;
		bool = new Boolean(true);
		bool = new Boolean("true");
		bool = new Boolean("TRUE");
		bool = new Boolean("TRue"); //"true", "TRUE", "TRue"
		
		System.out.println("Boolean true : " + bool);
		
		bool = new Boolean("false");
		bool = new Boolean("FALSE");
		bool = new Boolean("FAlse");
		bool = new Boolean("true1"); //true 가 아닌 문자열은 false
		bool = new Boolean("abcd"); 
		System.out.println("Boolean false : " + bool);
				
		System.out.println("--- String ---> Boolean ---");
		Boolean bool2 = Boolean.valueOf("true"); // Boolean <--- String
		boolean boo13 = Boolean.parseBoolean("true");
		
		System.out.println("=== Float, Double ===");
		Float f = 10.5f; // Float <--- float
		f = new Float(12.5);
		f = new Float("12.5f");
		f = new Float("12.5");
		
		System.out.println("Float f : " + f);
		
		//f = "12.5"; //Type mismatch: cannot convert from String to Float
		String str2 = String.valueOf(f); // String <--- Float
		System.out.println("String str2 : " + str2); 
		
		f = Float.valueOf("12.5f");
		System.out.println("Float f : " + f);
		System.out.println("----------------------");
		
		Double d = 10.5D; // Double <--- double
		d = new Double(12.5d);
		d = new Double("12.5d");
		System.out.println("Double d : " + d);
	
		d = Double.valueOf("12.5d");
		d = Double.valueOf("12.5");
		d = Double.valueOf("10.5f");
		System.out.println("Double d : " + d);
	}

}
