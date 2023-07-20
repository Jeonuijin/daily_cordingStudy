package com.mystudy.ex02_myexception;

import com.mystudy.ex03_sungjuk.SungjukProcessException;

public class JumsuOutOfvalueException extends SungjukProcessException{

	public JumsuOutOfvalueException() {
		super("점수범위(0~100)를 벗어난 값입니다");
	}
	
	public JumsuOutOfvalueException(String msg) {
		super(msg);
	}
	
	
	
}
