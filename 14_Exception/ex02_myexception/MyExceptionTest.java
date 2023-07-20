package com.mystudy.ex02_myexception;

public class MyExceptionTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		//throw new MyException("처음만든예외");
		
		try {
			firstMethod();
		} catch (MyException e) {
			//e.printStackTrace();
			System.out.println(">> main-catch 문 실행");
			System.out.println(">> 오류메시지 : " + e.getMessage());
		}
		
		
		System.out.println("--- main() 끝 ---");
	}

	private static void firstMethod() throws MyException {
		System.out.println("--- firstMethod() 시작---");
		secondMethod();
		System.out.println("--- firstMethod() 끝---");
		
	}

	private static void secondMethod() throws MyException {
		System.out.println("--- secondMethod() 시작 ---");
		//예외 발생시키기
		throw new MyException("secondMethod()에서 예외 발생");
		//System.out.println("--- secondMethod() 끝 ---");
		
	}

}
