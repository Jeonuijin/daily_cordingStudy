package com.mystudy.poly4_interface;

public class Cat extends AbstractAnimal{

	public Cat() {
		super("고양이");
	}
	
	
	@Override
	public void sound() {
		System.out.println(super.getName() +  ">> 야옹~ 야옹~");
	}
	
	public void test() {
		System.out.println("테스트");
	}
}
