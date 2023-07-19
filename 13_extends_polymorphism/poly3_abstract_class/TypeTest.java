package com.mystudy.poly3_abstract_class;

class TypeTest {

	public static void main(String[] args) {
		//AbstractAnimal animal = new AbstractAnimal()
		Cat cat = new Cat();
		cat.sound();
		
		Dog dog = new Dog();
		dog.sound();
		
		System.out.println("--------------");
		sound(cat);
		sound(dog);

	}
	
	// 부모 클래스인 추상클래스 타입으로 받아서 처리
	static void sound(AbstractAnimal animal) {
		animal.sound();
		
	}
	
}
