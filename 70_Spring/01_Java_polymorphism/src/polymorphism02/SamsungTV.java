package polymorphism02;

public class SamsungTV implements TV{
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원 OFF");
	}
	@Override
	public void VolumeUp() {
		System.out.println("SamsungTV - 소리크게");
	}
	
	public void VolumeDown() {
		System.out.println("SamsungTV - 소리작게");
	}
}
