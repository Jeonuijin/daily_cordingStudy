package com.mystudy.poly4_interface;

public class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		Pig pig = new Pig();
		
		cat.sound();
		cat.eat();
		cat.sleep();
		cat.test();
		
		dog.sound();
		System.out.println("==== Animal 타입 사용(Cat 객체) ====");
		Animal animal = new Cat();
		animal.eat();
		animal.sleep();
		animal.sound();
		
		//타입변경시 해당 데이터 타입에 정의된 기능(메소드)만 사용가능
		
		System.out.println("==== 메소드 파라미터 Animal 인터페이스 사용 ====");
		soundPoly(cat);
		soundPoly(dog);
		soundPoly(pig);
	
	}
	// 인터페이스 Animal 타입으로 데이터를 받아서
	// 인터페이스 타입에 저장된 데이터에 있는 sound() 메소드 호출
	// (메소드 오버라이딩에 의해 저장된 객체의 메소드 호출)
	static void soundPoly(Animal animal) {
			animal.sound();
		}
}
