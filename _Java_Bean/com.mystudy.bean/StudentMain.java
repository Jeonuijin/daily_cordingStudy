package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		System.out.println("stu : " + stu.toString());

		//System.out.println("stu.name : " + stu.name); //not visuble
		stu.setName("홍길동");
		String name = stu.getName();
		System.out.println("name : " + name);
		System.out.println("name : " + stu.getName());
		
		//stu.kor = 999;  ---> class가 private이기 때문에 직접적으로 값설정X
		//System.out.println("kor : " + stu.kor);
		System.out.println("입력전kor : " + stu.getKor());
		stu.setKor(100);
		System.out.println("입력후kor : " + stu.getKor());
		
		stu.setEng(90);
		System.out.println("eng : " + stu.getEng());
		
		stu.setMath(80);
		System.out.println("eng : " + stu.getMath());
		
		int tot = stu.getKor() + stu.getEng() + stu.getMath();
		System.out.println("tot : " + tot);
		
		stu.setTot(tot);
		
		double avg = tot * 100 / 3 / 100.0;
		System.out.println("avg : " + avg);
		
		stu.setAvg(avg);
		
		stu.printData();
		System.out.println();
		
		System.out.println("==== 생성자 사용 데이터 입력 ====");
		Student stu2 = new Student("김유신");
		
		stu2.printData();
		
	}

}
