package com.mystudy.bean_vo;

// 자바빈(Java Bean) 형태의 클래스 작성
// VO(Value Object) : 값(데이터)을 저장하기 위한 클래스(객체) - Oxxxx, OxxxVO, OxxxVo
// DTO(Data Transfer Object) : 값(데이터)을 저장해서 전달하기 위한 클래스(객체)
// 	  Oxxxx, OxxxDTO, OxxxxDto
public class StudentVO {
	//필드(변수)선언 ------------
	//성명 - name : String
	//국어 - kor : int
	//영어 - eng : int
	//수학 - math : int
	//총점 - tot : int
	//평균 - avg : double
	
	//생성자 작성 ---------------
	//생성자 = 성명, 국어, 영어, 수학 점수를 입력받는 생성자
	
	//메소드 작성 ---------------
	// setters, getters 모두 작성
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public StudentVO() {
	}
	
	public StudentVO(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		if (kor >= 0 && kor <= 100) {
			this.kor = kor;
		}else {
			System.out.print("잘못된 점수입니다.");
		}
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public void printData() {
		
		System.out.print(name + "\t" + kor + "\t"
				+ eng + "\t" + math + "\t" + tot + "\t" + avg);
		
		System.out.println();
	}
	

	private void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
		
	
	
	
}
