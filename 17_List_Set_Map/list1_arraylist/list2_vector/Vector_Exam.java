package com.mystudy.list2_vector;

import java.awt.List;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Vector_Exam {

	public static void main(String[] args) {
		// Vector 클래스 : List 인터페이스 구현체
		Vector<String> v = new Vector<String>();
		//List<String> v = new Vector<String>();
		v.add("1");
		v.add("2");
		v.add("3");
		
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());

		String temp = v.toString();
		System.out.println(temp);
		
		v.remove(2);
		System.out.println("v.remove(2) : " + v);
		
		System.out.println("--- v.trimToSize() 실행후 ---");
		v.trimToSize();
		System.out.println(v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.addElement("4문자열");
		System.out.println(v);
		
		v.add("AAA"); //맨뒤에 추가
		System.out.println(v);
		
		v.add(2, "BBB"); // 삽입, 특정위치에 입력(insert)
		System.out.println(v);
		
		Vector<String> v2 = (Vector)v.clone();
		System.out.println("v : " + v);
		System.out.println("v2 : " + v2);
		
		//주소값 복사인지 물리적으로 분리된 복사본인지 확인
		System.out.println(v.equals(v2));
		System.out.println(v == v2);
		
		System.out.println("=======================");
		Enumeration<String> enu = v.elements(); //전체데이터를 Enumeration에 담아서 준다
		while (enu.hasMoreElements()) {
			System.out.println("enu.nextElement() : " + enu.nextElement());
		}
		System.out.println("---------------");
		//(개인별) 기본 for문 사용해서 화면출력(Enumeration 객체 사용)
		
		//=======================
		Iterator<String> ite = v.iterator(); //인터러블 인터페이스를 구현한 객체
		System.out.println("ite.hasNext : " + ite.hasNext());
		while (ite.hasNext()) {
			System.out.println("ite.next : " + ite.next());
		}
		System.out.println("ite.hasNext : " + ite.hasNext());
		
		System.out.println("==== 개선된 for문 사용 데이터 조회 ====");
		for (String str : v) {
			System.out.println(str);
		}
		
	}

}
