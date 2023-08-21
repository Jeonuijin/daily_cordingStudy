
public class Ex04_short {

	public static void main(String[] args) {
		//정수형 short : 2byte(갯수: 65536, 범위: -32768 ~ 32767
		short short1 = 20000;
		short short2 = 30000;
		
		System.out.println("short1 : " + short1);
		System.out.println("short2 : " + short2);
		
		//표현범위 벗어나면 원치않는 결과값을 가짐
		short sum = (short)(short1 + short2);
		System.out.println("short sum : " + sum); //-15536
		
		int sumInt = short1 + short2;
		System.out.println("int sumInt : " + sumInt); //50000
	}

}
