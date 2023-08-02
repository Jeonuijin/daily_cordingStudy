package com.mystudy.ex04_printwriter;

import java.util.Calendar;

public class printf_Exam {

	public static void main(String[] args) {
		// printf() 메소드 사용시 형식문자 사용
		int a = 20;
		long b = 300_000_000_000L;
		float c = 34.95f;
		double d = 234.234;
		char e ='A';
		String f = "Hello~~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF", today);
		System.out.println();
		
		System.out.println(">>" + a + " " + b +" " + c + " " + d
						 + " " + e + " " + d + " " + e + " " + f + " " + g);
		System.out.println();
		
		/* [] : 생략가능
		 * %[인덱스$][-][크기]형식문자 : %, 형식문자 필수
		 * -기본은 우측정렬
		 * -마이너스 부호는 좌측정렬
		 *-------------------------------------*/
		 System.out.printf("%d %d %c %s%n", 100, 123, 'A', "Hello~");
	
		 System.out.println("--- 인덱스(파라미터위치값) 사용 ----");
		//[인덱스%] 파라미터 위치값 $ 부호와 함께 사용
		//$숫자값은 인덱스를 의미하는데 데이터 매칭에 영향을 주지 않는다.//즉 $숫자값 이후부터 첫번째 값과 매칭된다.
		 System.out.printf("%1$d %1$d %c %s%n", 65, 'A', "Hello~~");
		 
		 System.out.println("--- 실수형 데이터 표시 ----");
		 System.out.printf("%f %1$a %1$e %1$g %n", 65.812345678);//특별한 경우가 아니면 보통%f를 쓴다.
		 System.out.printf("%10.3f %n", 65.567890);  //전체자리수 10, 소수점이하 3
		 System.out.printf("%-10.3f %n", 65.567890);
		 System.out.printf("%30.10f %n", 65.56789012345);
		 
		 System.out.println("-------- 날짜관련 -----------");
		 System.out.printf("%tF %n", today); // 2023-08-02
		 System.out.printf("%tT %n", today); // 16:00:35
		 System.out.printf("%ta %n", today); // 수
		 System.out.printf("%1$tY/%1$tm/%1$td(%1$ta) %n", today); //2023/08/02
		 System.out.printf("%1$tH:%1$tM:%1$tS %n", today); //16:00:35
		 System.out.println("===============================");
		 
		 String name = "홍길동";
		 int kor = 100, eng = 90, math = 81;
		 System.out.printf("%s은 국어 %d, 영어 %d, 수학 %d 입니다.%n",
				 		name, kor, eng, math);
	}

}


