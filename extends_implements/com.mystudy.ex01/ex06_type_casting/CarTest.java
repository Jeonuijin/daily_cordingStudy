package com.mystudy.ex06_type_casting;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("==== Car 클래스 ====");
		Car car = new Car();
		car.type = "자동차";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("==== Ambulance 클래스 ====");
		Ambulance am = new Ambulance();
		
		am.type = "구급차";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("==== FireEngine 클래스 ====");
		FireEngine fe = new FireEngine();
		fe.type = "소방차";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("==== 형변환 ====");
		// Car, Ambulance, FireEngine
		Car car2 = new Car(); // 
		//Car <-- Car
		car2.type = "자동차";
		System.out.println("type : " + car2.type);
		car2.drive();
		car2.stop();
		
		//car2.siren(); //컴파일 오류 is undefined : Car 타입에는 siren() 없음
		
		System.out.println("--- Car <--- Ambulance 저장 ---");
		// Car <--- Ambulance : 부모(상위)타입 <--- 자녀(하위)타입 (자동형변환)
		// 부모(상위)클래스에 자녀(하위)클래스를 저장
		car2 = am; // Car <-- Ambulance : 자동형변환
		System.out.println("car2 type : " + car2.type);
		car2.drive();
		car2.stop();
		
		//앱뷸런스 고유기능 siren() 사용하려면 Ambulance 타입이 되어야 한다.
		((Ambulance)car2).siren();
		
		//======================
		System.out.println("--- Ambulance <--- Car <--- Ambulance");
		System.out.println("car2 type : " + car2.type);
		Ambulance am2 = (Ambulance) car2; // Car 타입에 저장되어 있던 Ambulance
		am2.drive();
		am2.stop();
		am2.siren();
		
		// 자녀(하위)클래스에 부모(상위)클래스를 저장
		System.out.println("--- Ambulance <--- Car ---");
		Car carTemp = new Car();
		carTemp.type = "일반자동차";
		//Ambulance am2 = (Ambulance) carTemp; //강제 형변환 문법적으로 가능하나 실행 시 오류.
		//System.out.println("carTemp type : "+ carTemp.type);
	}

}
