package com.mystudy.bean_vo;

public class StudentManager {

	public static void main(String[] args) {
		/* 3명의 성적 처리 StudentVO 사용
		 "김유신", 100, 90, 81
		 "이순신", 95, 88, 92
		 "홍길동", 90, 87, 77  //각자의 객체 만들기
		 *===================
		 김유신	100	90	81	271	90.33
		 이순신	95	88	92	???	???
		 홍길동	90	87	77	???	???
		 --------------------------*/
		StudentVO st = new StudentVO();
		
		StudentVO st1 = new StudentVO("김유신", 200, 90, 81);
		StudentVO st2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO st3 = new StudentVO("홍길동", 90, 87, 77);
		
		int tot = st.getEng() + st.getKor() + st.getMath();
		st.setTot(tot);
	
		
		double avg = tot * 100 / 3 / 100.0;
		st.setAvg(avg);
		
		
		st1.printData();
		st2.printData();
		st3.printData();
		
		
		
		
		
	}

}
