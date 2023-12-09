package com.spring.biz.common;

public class AfterReturningAdvice {
	public void aferReturnLog() {
		System.out.println("[후처리-AfterReturningAdvice.afterReturnLog"
				+"비즈니스 로직 수행 후 로그(정상실행시)");
		
	}
}
