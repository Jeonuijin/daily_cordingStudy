package com.mystudy.set2_exam_vo;

public class StudentVO {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	//생성자 마음대로 만들기
	
	public StudentVO(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = 0;
		this.avg = 0;
	}
	

	//메소드 마음대로 만들기
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + eng;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + tot;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (eng != other.eng)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tot != other.tot)
			return false;
		return true;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
		num (); // set에다가 계산한 메소드를 추가하면 Main에서 값을 변경할때마다 호출하지 않아도 된다.
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
		num ();
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
		num ();
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
		num ();
	}


	public int getTot() {
		return tot;
	}

//임의대로 토탈값과 평균값을 바꾸지 못하게 주석처리한다.(num()에 있는 계산값만 나올 수 있도록)
//	public void setTot(int tot) {
//		this.tot = tot;
//	}


	public double getAvg() {
		return avg;
	}


//	public void setAvg(double avg) {
//		this.avg = avg;
//	}


	public void num () {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100;
	}


	
	public String toString() {
		return name + "\t" 
				+ kor + "\t"
				+ eng +  "\t"
				+ math + "\t" 
				+ tot +  "\t" 
				+ avg;
	}
	
	
	
}
