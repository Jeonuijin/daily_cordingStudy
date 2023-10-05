package com.mystudy.common;

import java.sql.Date;

public class EmployeeVO {
	private int sabun;	//고유의 객체를 가져야 하므로 static을 붙이지 않는다.
	private String name;
	private Date regdate;
	private int pay;
	
	public EmployeeVO() {
		super();

	}
	
	public EmployeeVO(int sabun, String name, Date regdate, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.regdate = regdate;
		this.pay = pay;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "EmployeeVO [sabun=" + sabun + ", name=" + name + ", regdate=" + regdate + ", pay=" + pay + "]";
	}
	
}
