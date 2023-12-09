package polymorphism02;

public class TVUser {
	
	public static void main(String[] args) {
		//삼성TV 사용
		//SamsungTV tv = new SamsungTV();
		//LgTV tv = new LgTV();
		//TV tv = new LgTV();
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.VolumeUp();
		tv.VolumeDown();
		tv.powerOff();
	}
}
