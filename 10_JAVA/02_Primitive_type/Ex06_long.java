
public class Ex06_long {

	public static void main(String[] args) {
		// 정수형 long : 8byte
		// 범위 : -9223372036854775808 ~ 9223372036854775807
		// long 타입값 명시적 표현 : 숫자 + L 또는 l(영문 대소문자 엘)
		long num1 = 20000000000L; //long을 의미하는 접미어 L 사용
		long num2 = 30000000000l; //long을 의미하는 접미어 L 사용
		long sum = num1 + num2;
		System.out.println(num1 + " + " + " + " + num2 + " = " + sum);
		System.out.println("==========================");
		
		byte numByte = 10;
		short numShort = 3000;
		int numInt = 3000000;
		long numLong = 5000000000000000L;
	
		numByte = (byte) numShort; //손실발생 가능성있음(강제형변환) - 쓰레기값 발생
		System.out.println("numByte : " + numByte);
		
		numLong = numInt; //자동형변환 long타입 <- int 타입
		System.out.println("numLong : " + numLong);
		
		System.out.println("long 최소값 : " + Long.MIN_VALUE);
		System.out.println("long 최대값 : " + Long.MAX_VALUE);

	}

}
