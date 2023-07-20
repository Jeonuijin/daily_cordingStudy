package com.mystudy.ex03_sungjuk;

import com.mystudy.ex02_myexception.JumsuOutOfvalueException;

public class SungjukTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ----");
		SungjukVO stu = new SungjukVO("홍길동", 100, 90, 80, 0, 0);
		stu.setKor(999);
		
		System.out.println("---setEng() 처리 ---");
		try {
			stu.setEng(999);
		} catch (JumsuOutOfvalueException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage() +
					" : 0~100 범위의 값으로 다시 입력하세요");
		} catch (SungjukProcessException e) {
			System.out.println("[예외발생] 성적처리중 예외발생");
		}
		
		
		System.out.println("stu : " + stu);
		
		
		
		System.out.println("--- main() 끝 ----");

	}

}
