package com.mystudy.ex01_exception;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("--- main() 시작---");
		int num1 = 100;
		int num2 = 100;
		int result = 0;
		System.out.println(">> 연산 시작");
		
		//result = num1 / num2; //ArithmeticException: / by zero
		
		//예외처리 -----------
		if (num2 == 0) {
			System.out.println("[예외발생] 나누는 값이 0입니다");
		} else {
			result = num1 / num2;
			System.out.println("연산결과 result : " + result);
		}
		System.out.println();
		
		System.out.println("==== try ~ catch 예외처리 ====");
		try {
			System.out.println("-- try문 시작 --");
			result = num1 / num2;
			System.out.println("연산결과 result : " + result);
			System.out.println("-- try문 종료 --");
			//return; //메서드 종료
		} catch (ArithmeticException e) {
			System.out.println("[예외발생] 나누는 값이 0입니다");
			System.out.println("[예외발생-ArithmeticException]" + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("[예외발생-ArithmeticException]" + e.getMessage());
		} catch (Exception e) {
			System.out.println("[예외발생-Exception]" + e.getMessage());
		} finally {
			System.out.println("**>>>>finaly : 항상(무조건) 실행");
		}
		
		System.out.println("test : try~catch~finally 이후 문장");
		
		System.out.println("--- main() 끝 ---");

		
		
		
		
		
	}

}
