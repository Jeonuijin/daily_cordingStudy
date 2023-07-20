package com.mystudy.generic;

class Box {
	Object obj; //필드(멤버) 변수의 타입

	Object getObj() { //리턴타입
		return obj;
	}

	void setObj(Object obj) { //파라미터 타입(매개변수)
		this.obj = obj;
	}
	
}

//제네릭 적용된 박스
class BoxG<T> {
	T obj;
	
	T getObj() {
		return obj;
	}
	void setObj(T obj) { 
		this.obj = obj;
	}
	
}

public class GenericExam {

	public static void main(String[] args) {
		/*
		 ■ 제네릭/제너릭(Generic) : 컬렉션이 어떤 객체들로 이루어졌는지 표시하는 객체타입을 의미
		  제네릭 형태 : <객체자료형>, <>
		    API -> <T> : 객체자료형, <E> : 하나의 요소(즉 객체 하나를 의미)
		           Map형식 : <K, V> K는 key(키), V는 value(값)
		  -----------------
		  제네릭(Generic)의 대표문자(wildcard)
		    1. <?> : 모든 타입(객체) 자료형에 대한 대표문자를 의미
		    2. <? extends 자료형> : 자료형을 상속받은 자녀(sub) 클래스 타입 사용
		    3. <? super 자료형> : 자료형의 부모(super) 타입 사용           
		-------------------------------------------------------*/
		// 제네릭 사용 안한 Box를 사용하는 경우
		Box box = new Box();
		box.setObj("문자열 String");
		box.setObj(100);
		box.setObj(new Box());
		box.setObj(new Integer(100000));
		System.out.println(box.getObj());
		
		Integer integer = (Integer)box.getObj();
		System.out.println("integer : " + integer);
		System.out.println(integer.MAX_VALUE);
		
		String str = "Hello Java";
		String str2 = "100000";
		int str3 = 333;
		
		System.out.println("==== 제네릭 적용 클래스 사용 ====");
		BoxG<String> boxg = new BoxG<String>();
		boxg.setObj("문자열 String");
		boxg.setObj(str);
		boxg.setObj(str2);
		//boxg.setObj(str3); //타입이 일치하지 않으면 컴파일 오류 발생
		
		String strValue = boxg.getObj();
		System.out.println("strValue : " + strValue);
		System.out.println(boxg.getObj());
		
	}

}
